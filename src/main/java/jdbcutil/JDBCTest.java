package jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTest {
    public static void main(String[] args) throws Exception {
        //1. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/cargo_db";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        //2. 定义sql
        String sql = "select * from cargo where id = ? and standard = ?";
        //3. 获取执行sql的对象 Statement
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, 46);
        pstmt.setString(2, "111");
        //4. 执行sql
        ResultSet rs = pstmt.executeQuery();
        //5. 处理结果
//        System.out.println(rs.next());
        while(rs.next()){
            System.out.println("name:" +  rs.getString("name") + "  " +
                                "位置：" + rs.getString("location"));
            System.out.println(rs.getMetaData().getColumnCount());
        }

        //6. 释放资源
        pstmt.close();
        conn.close();
    }
}
