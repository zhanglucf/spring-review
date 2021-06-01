package com.example.service.iml;

import com.example.domain.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
