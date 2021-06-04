package com.example.service.iml;

import com.example.domain.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Object[] args) {
        String sql = "insert into student (id,name) values (?,?)";
        jdbcTemplate.update(sql, args);
    }

    @Override
    public Student findById(Long id) {
        String sql = "select * from student where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), id);
    }

    @Override
    public List<Student> findAll() {
        String sql = "select * from student";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        return studentList;
    }

    @Override
    public int[] batchInsert(List<Object[]> objects) {
        String sql = "insert into student (id,name) values (?,?)";
        final int[] ints = jdbcTemplate.batchUpdate(sql, objects);
        return ints;
    }


    @Override
    public void statementBatchInsert() {
        long startTime = System.currentTimeMillis();

        // Initialize conn&stmt
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = jdbcTemplate.getDataSource().getConnection();
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            String ctime = "2017-11-01 00:00:01";
            int index = 0;

            for (int i = 0; i < 10000; i++) {
                String insertSql = "insert into emp (name,age,cdate) values";
                List<String> list = new ArrayList<String>();

                for (int j = 0; j < 1000; j++) {
                    index++;

                    Object arr[] = {"'E:" + index + "'", index % 100, "'" + ctime + "'"};
                    String valueSql = MessageFormat.format("({0},{1},{2})", arr);
                    list.add(valueSql);

                    ctime = timePastOneSecond(ctime);
                }

                String sql = insertSql + String.join(",", list);
                stmt.addBatch(sql);
                stmt.executeBatch();
                conn.commit();
                System.out.println("#" + i + " 1000 records have been inserted to table:'emp'.");
            }
        } catch (SQLException e) {
            System.out.println("Error happened:" + e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("Can not rollback because of the error:'" + e + "'.");
            }
        } finally {
            try {
                stmt.close();
                conn.close();

                long endTime = System.currentTimeMillis();
                System.out.println("Time elapsed:" + toDhmsStyle((endTime - startTime) / 1000) + ".");
            } catch (SQLException e1) {
                System.out.println("Can not close connection because of the error:'" + e1 + "'.");
            }
        }
    }


    @Override
    public void statementBatchInsert2() {
        long startTime = System.currentTimeMillis();
        IntStream.range(0, 5)
                .parallel()
                .peek(i -> doBatchInsert())
                .count();
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时:" + toDhmsStyle((endTime - startTime) / 1000) + ".");
    }


    @Override
    public void statementBatchInsert3() {
        long startTime = System.currentTimeMillis();
        IntStream.range(0, 5)
                .parallel()
                .peek(i -> doBatchInsert2())
                .count();
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时:" + toDhmsStyle((endTime - startTime) / 1000) + ".");
    }

    private void doBatchInsert() {

        long startTime = System.currentTimeMillis();

        // Initialize conn&stmt
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = jdbcTemplate.getDataSource().getConnection();
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            String ctime = "2017-11-01 00:00:01";
            int index = 0;

            for (int i = 0; i < 200; i++) {
//                String insertSql = "insert into batch_data (f1,f2,f3,f4,f5,f6,f7,f8,f9,f10) values";
                String insertSql = "insert into emp (name,age,cdate) values";
                List<String> list = new ArrayList<String>();
                for (int j = 0; j < 1000; j++) {
                    index++;

                    Object arr[] = {"'E:" + index + "'",
                            index % 100,
                            "'" + ctime + "'",
                            "'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'"};

//                                        Object arr[] = {
//                                                "'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'",
//                                                "'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'",
//                                                "'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'",
//                                                "'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'",
//                                                "'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'",
//                                                "'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'",
//                                                "'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'",
//                                                "'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'",
//                                                "'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'",
//                                                "'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'"
//                                        };
//                    String valueSql = MessageFormat.format("({0},{1},{2},{3},{4},{5},{6},{7},{8},{9})", arr);
                    String valueSql = MessageFormat.format("({0},{1},{2})", arr);

                    list.add(valueSql);

                    ctime = timePastOneSecond(ctime);
                }

                String sql = insertSql + String.join(",", list);
                stmt.addBatch(sql);
                stmt.executeBatch();
                conn.commit();
            }
        } catch (SQLException e) {
            System.out.println("Error happened:" + e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("Can not rollback because of the error:'" + e + "'.");
            }
        } finally {
            try {
                stmt.close();
                conn.close();

                long endTime = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName() + "耗时：" + toDhmsStyle((endTime - startTime) / 1000) + ".");
            } catch (SQLException e1) {
                System.out.println("Can not close connection because of the error:'" + e1 + "'.");
            }
        }
    }

    private void doBatchInsert2() {

        long startTime = System.currentTimeMillis();

        // Initialize conn&stmt
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = jdbcTemplate.getDataSource().getConnection();
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            String ctime = "2017-11-01 00:00:01";
            int index = 0;

            for (int i = 0; i < 200; i++) {
                String insertSql = "insert into batch_data (f1,f2,f3,f4,f5,f6,f7,f8,f9,f10) values";
                List<String> list = new ArrayList<String>();
                for (int j = 0; j < 1000; j++) {
                    index++;
                    Object arr[] = {
                            "'aaaaa'",
                            "'aaaaa'",
                            "'aaaaa'",
                            "'aaaaa'",
                            "'aaaaa'",
                            "'aaaaa'",
                            "'aaaaa'",
                            "'aaaaa'",
                            "'aaaaa'",
                            "'aaaaa'"

                    };
                    String valueSql = MessageFormat.format("({0},{1},{2},{3},{4},{5},{6},{7},{8},{9})", arr);
                    list.add(valueSql);

                    ctime = timePastOneSecond(ctime);
                }

                String sql = insertSql + String.join(",", list);
                stmt.addBatch(sql);
                stmt.executeBatch();
                conn.commit();
            }
        } catch (SQLException e) {
            System.out.println("Error happened:" + e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("Can not rollback because of the error:'" + e + "'.");
            }
        } finally {
            try {
                stmt.close();
                conn.close();

                long endTime = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName() + "耗时：" + toDhmsStyle((endTime - startTime) / 1000) + ".");
            } catch (SQLException e1) {
                System.out.println("Can not close connection because of the error:'" + e1 + "'.");
            }
        }
    }


    public static String timePastOneSecond(String otime) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dt = sdf.parse(otime);

            Calendar newTime = Calendar.getInstance();
            newTime.setTime(dt);
            newTime.add(Calendar.SECOND, 1);

            Date dt1 = newTime.getTime();
            String retval = sdf.format(dt1);

            return retval;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String toDhmsStyle(long allSeconds) {
        String DateTimes = null;

        long days = allSeconds / (60 * 60 * 24);
        long hours = (allSeconds % (60 * 60 * 24)) / (60 * 60);
        long minutes = (allSeconds % (60 * 60)) / 60;
        long seconds = allSeconds % 60;

        if (days > 0) {
            DateTimes = days + "d" + hours + "h" + minutes + "m" + seconds + "s";
        } else if (hours > 0) {
            DateTimes = hours + "h" + minutes + "m" + seconds + "s";
        } else if (minutes > 0) {
            DateTimes = minutes + "m" + seconds + "s";
        } else {
            DateTimes = seconds + "s";
        }

        return DateTimes;
    }

}
