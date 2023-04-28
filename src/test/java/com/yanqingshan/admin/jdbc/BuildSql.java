package com.yanqingshan.admin.jdbc;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过JDBC备份 库表数据
 *
 * @author yanqs
 * @date 2023年04月28日 9:31
 */
@SpringBootTest
class BuildSql {

    @Test
    void testBuildSql() throws ClassNotFoundException, SQLException, IOException {
        String dbUrl = "jdbc:mysql://192.168.57.110:3306/boot-startup";
        String username = "test";
        String password = "123456";

        // 加载JDBC驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 建立数据库连接
        Connection conn = DriverManager.getConnection(dbUrl, username, password);

        // 创建Statement对象
        Statement stmt = conn.createStatement();

        // 查询所有表格名字
        ResultSet result = stmt.executeQuery("SHOW TABLES");
        FileWriter writer = new FileWriter("backup.sql");

        // 循环遍历所有表 存表
        List<String> tableNameList = new ArrayList<>();
        while (result.next()) {
            tableNameList.add(result.getString(1));
        }
        for (String tableName : tableNameList) {
            // 在输出文件中写入创建表格SQL语句
            ResultSet rs = stmt.executeQuery("SHOW CREATE TABLE " + tableName);
            if (rs.next()) {
                writer.write("\n\n" + rs.getString(2) + ";\n\n");
            }

            // 循环遍历表格中的所有行来写入数据
            rs = stmt.executeQuery("SELECT * FROM " + tableName);
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                writer.write("INSERT INTO " + tableName + " VALUES (");
                for (int i = 1; i <= columnCount; i++) {
                    writer.write("'" + rs.getString(i) + "'");
                    if (i < columnCount) {
                        writer.write(",");
                    }
                }
                writer.write(");\n");
            }
        }

        // 关闭所有连接
        writer.close();
        result.close();
        stmt.close();
        conn.close();
    }
}
