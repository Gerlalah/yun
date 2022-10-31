package cn.wolfcode.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection conn(){
        //定义地址，"jdbc:mysql://ip地址:端口号/数据库名"
        String url = "jdbc:mysql://localhost:3306/javawebdemo1";
        Connection connection = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接，用户名：root，密码：hello
            connection = DriverManager.getConnection(url, "root", "1234");
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }
}
