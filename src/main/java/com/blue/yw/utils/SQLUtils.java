package com.blue.yw.utils;

import com.blue.yw.model.NominationVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SQLUtils {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://rm-bp14f3jcp5sx75d9b3o.mysql.rds.aliyuncs.com:3306/yw";
    private static final String user = "root";
    private static final String password = "yuWan654321";

    public static void insertNomination(NominationVO nominationVO) {
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 链接数据库
            Connection conn = DriverManager.getConnection(url, user, password);
            if (!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");

            Calendar calendar = Calendar.getInstance();
            Date startDate = new Date(calendar.getTime().getTime());
            // the mysql insert statement
            String query = " insert into nomination (SHORT_NAME, USER_NAME, CREATE_DATE, STATE)" + " values (?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, nominationVO.getShortName());
            preparedStmt.setString(2, nominationVO.getUserName());
            preparedStmt.setDate(3, startDate);
            preparedStmt.setString(4, "1");

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<NominationVO> queryNomination() {
        List<NominationVO> nominationVOList = new ArrayList<>();
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 链接数据库
            Connection conn = DriverManager.getConnection(url, user, password);
            if (!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");

            // statement用来执行SQL语句
            Statement statement = conn.createStatement();
            // 要执行的SQL语句id和content是表review中的项。
            String sql = "SELECT * FROM nomination";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("SHORT_NAME") + "\t" + rs.getString("USER_NAME"));
                NominationVO vo = new NominationVO();
                vo.setShortName(rs.getString("SHORT_NAME"));
                vo.setUserName(rs.getString("USER_NAME"));
                nominationVOList.add(vo);
            }

            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nominationVOList;
    }

    public static void main(String[] args) {

    }
}
