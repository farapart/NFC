package com.example.c_stephen.nfc;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Result;

public class DBManager {
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String dbURL = "jdbc:mysql://111.231.170.52:3306/softwareDB?serverTimezone=UTC";
    private static String userName = "root";
    private static String userPwd = "123456";
    public static boolean end = false;

    public static boolean newAccount(UserInfo user) {
        String sql = "INSERT INTO userTable(userName, idCard, phone, password, role) " +
                " VALUES(?, ?, ?, ?, ?)";
        Object []args = {user.getUserName(), user.getIdCard(), user.getPhone(), user.getPassword(), user.getRole()};
        Update temp = new Update(sql, args);
        Thread thread = new Thread(temp);
        thread.start();
        while(!end);
        end = false;
        return temp.flag;
    }

    public static boolean getUser(String userName, UserInfo user) {
        String sql = "SELECT * FROM userTable WHERE userName=?";
        Object []args = {userName};
        Query temp = new Query(sql, args);
        Thread thread = new Thread(temp);
        thread.start();
        while(!end);
        end = false;
        boolean result = false;
        if(!temp.list.isEmpty()){
            result = true;
            user.setID(Integer.parseInt(String.valueOf(temp.list.get(0).get("id"))));
            user.setUserName(String.valueOf(temp.list.get(0).get("userName")));
            user.setIdCard(String.valueOf(temp.list.get(0).get("idCard")));
            user.setRole(Integer.parseInt(String.valueOf(temp.list.get(0).get("role"))));
            user.setPhone(String.valueOf(String.valueOf(temp.list.get(0).get("phone"))));
            user.setPassword(String.valueOf(String.valueOf(temp.list.get(0).get("password"))));
        }
        return result;
    }



    /*
     * @param userInfo 用户信息
     * @param childInfo 返回的子女信息
     * @return 操作是否成功
     */
    public static boolean getChildInfo(UserInfo userInfo, ArrayList<BindingInfo> bindingInfo) {
        String sql = "SELECT * FROM bindingTable WHERE pid=?";
        Object []args = {userInfo.getID()};
        Query temp = new Query(sql, args);
        Thread thread = new Thread(temp);
        thread.start();
        while(!end);
        end = false;
        boolean result = false;
        if(!temp.list.isEmpty()){
            for(Map map: temp.list){
                BindingInfo bindInfo = new BindingInfo( String.valueOf(map.get("childName")), String.valueOf(map.get("childPhone")),
                        String.valueOf(map.get("parentName")), String.valueOf(map.get("parentPhone")));
                bindingInfo.add(bindInfo);
            }
            result = true;
        }
        return result;
   }

    /**
     * 添加订单信息
     * @param cartInfo 订单记录
     * @return 添加是否成功
     */
    public static boolean insertCartInfo(CartInfo cartInfo) {
        String sql = "INSERT INTO cartTable(shopperID, parentID,childID, " +
                "appleNumber, applePrice, pearNumber, pearPrice, bananaNumber, " +
                "bananaPrice, watermelonNumber,watermelonPrice, totalPrice, payFlag) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object []args = {cartInfo.getShopperID(),cartInfo.getParentID(), cartInfo.getChildID(), cartInfo.getAppleNumber(),
                cartInfo.getApplePrice(),cartInfo.getPearNumber(),cartInfo.getPearPrice(),cartInfo.getBananaNumber(),cartInfo.getBananaPrice(),
                cartInfo.getWatermelonNumber(),cartInfo.getWatermelonPrice(),cartInfo.getTotalPrice(),cartInfo.getPayFlag()};
        Update temp = new Update(sql, args);
        Thread thread = new Thread(temp);
        thread.start();
        while(!end);
        end = false;
        return true;
    }

    /**
     * 获取数据库连接
     * @return
     */
    private static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbURL, userName, userPwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }


    static class Update implements Runnable{
        String SQL;
        Object []args;
        boolean flag = false;

        public Update(String SQL, Object[] args) {
            this.SQL = SQL;
            this.args = args;
        }

        public void setValue(String SQL, Object []args){
            this.SQL = SQL;
            this.args = args;
        }

        @Override
        public void run(){
            Connection conn = null;
            PreparedStatement pStmt = null;
            try {
                conn = getConn();
                pStmt = conn.prepareStatement(SQL);
                if (args != null && args.length > 0) {
                    for (int i = 0; i < args.length; i++) {
                        pStmt.setObject(i + 1, args[i]);
                    }
                }
                int result = pStmt.executeUpdate();
                if (result > 0)
                    flag = true;
                    end = true;
                    return;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (pStmt != null)
                        pStmt.close();
                    if (conn != null)
                        conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            flag = false;
            end = true;
            return;
        }
    }

    static class Query implements  Runnable{
        String SQL;
        Object []args;
        ResultSet rs = null;
        ArrayList<Map> list = new ArrayList();

        public Query(String SQL, Object[] args) {
            this.SQL = SQL;
            this.args = args;
        }

        @Override
        public void run(){
            Connection conn = null;
            PreparedStatement pStmt = null;
            try {
                conn = getConn();
                pStmt = conn.prepareStatement(SQL);
                if (args != null && args.length > 0) {
                    for (int i = 0; i < args.length; i++) {
                        pStmt.setObject(i + 1, args[i]);
                    }
                }
                rs = pStmt.executeQuery();
                ResultSetMetaData md = rs.getMetaData();//获取键名
                int columnCount = md.getColumnCount();//获取行的数量
                while(rs.next()) {
                    Map result = new LinkedHashMap();
                    for (int i = 1; i <= columnCount; i++) {
                        result.put(md.getColumnName(i), rs.getObject(i));//获取键名及值
                    }
                    list.add(result);
                }
                boolean temp = rs.next();
                end = true;
                return;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null)
                        rs.close();
                    if (pStmt != null)
                        pStmt.close();
                    if (conn != null)
                        conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            end = true;
            return;
        }
    }

}
