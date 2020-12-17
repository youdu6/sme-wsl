package com.wsl.SQLserver;

import java.sql.*;
public class SQL {
    public void connect() {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=student";
        String userName = "sa";
        String userPwd = "w20010904";
        Connection dbConn = null;
        try
        {
            Class.forName(driverName);
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("连接数据库成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.print("连接失败");
        }
    }
}