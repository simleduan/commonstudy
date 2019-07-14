package com.utils;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnPool {

    //连接池对象
    private List<Connection> pool;
    //最大连接数
    private static  final int POOL_MAX_SIZE = 100;
    //最小连接数
    private static  final int POOL_MIN_SIZE = 10;

    public void initPool(){
        if (pool == null){
            pool = new ArrayList<Connection>();
        }
        while (pool.size()<DBConnPool.POOL_MIN_SIZE){
//            long begin = System.currentTimeMillis();
            Connection con = DBConnPool.getCreateCon();
//            long end = System.currentTimeMillis();
//            System.out.println(end - begin);
            pool.add(con);
            System.out.println("初始化连接池，池中连接数为"+pool.size());

        }
    }

    public static Connection getCon(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/middlestage","root","root");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getCreateCon(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/middlestage","root","root");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public DBConnPool() {
        initPool();
    }

    public static void close(ResultSet rs, Statement ps, Connection conn){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从连接池中取一个连接，通常是最后一个
     * @return
     */
    public synchronized Connection getConnection(){
        int last_index = pool.size()-1;
        Connection connection = pool.get(last_index);
        pool.remove(last_index);
        return connection;
    }

    /**
     * 并不是真正的关闭，其实是将连接放回连接池
     * @param connection
     */
    public synchronized void closeConnection(Connection connection){
        if (pool.size()>=POOL_MAX_SIZE){
            try {
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        pool.add(connection);
    }

    @Test
    public void test(){
        DBConnPool pool = new DBConnPool();
    }
}
