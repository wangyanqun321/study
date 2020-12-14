package com.wyq.oracle;

import java.sql.*;

/**
 * @author 王艳群
 * @description OracleJdbcTest
 * @date 2020/8/5
 */
public class OracleJdbcTest {

    private static String USERNAME = "C##WYQ";
    private static String PASSWORD = "123456";
    private static String DRIVER = "oracle.jdbc.OracleDriver";
    private static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        PreparedStatement pst = connection.prepareStatement(
            "select COLUMN_NAME,DATA_TYPE,DATA_PRECISION,DATA_SCALE,CONCAT(CONCAT(DATA_PRECISION, ','), DATA_SCALE) as type  from all_tab_columns where table_name='wyq'");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            ResultSetMetaData metaData = rs.getMetaData();
            for(int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.print(rs.getObject(i) + "  ");
            }
            System.out.println();
        }
    }
}

