### 

# 批量插入数据

> 抛开数据字段数、字段值大小，去描述批量插入的速度、性能是不靠谱、不准确的。
>
> 使用`JDBCTemplate`原生的批量插入方法`batchUpdate()`性能比较差，大数据量场景不适合
>
> 推荐使用`Statement`  `executeBatch()`方法 + 多线程一起使用提高大数据量批量插入的性能。



通过`Statement` `executeBatch()`方法,向`MySql`中批量插入100万条数据，测试结果如下：

| 插入数据 | 数据库字段大小 | Java字段大小 | 字段数量 | 数据总大小 | 耗时    |
| -------- | -------------- | ------------ | -------- | ---------- | ------- |
| 100W     | `varchar(50)`  | 10           | 10       | 159`MB`    | 22`sec` |
| 100W     | `varchar(50)`  | 5            | 10       | 102`MB`    | 15`sec` |
| 100W     | `varchar(255)` | 5            | 10       | 102`MB`    | 16`sec` |
| 100W     | `varchar(50)`  | 30           | 10       | 396`MB`    | 54`sec` |
| 100w     | `varchar(50)`  | 10           | 3        | 51`MB`     | 11`sec` |



```java
private void doBatchInsert() {

        long startTime = System.currentTimeMillis();
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
                    Object arr[] = {"'aaaaa'", "'aaaaa'","'aaaaa'", "'aaaaa'","'aaaaa'","'aaaaa'", "'aaaaa'", "'aaaaa'","'aaaaa'","'aaaaa'"
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
```

