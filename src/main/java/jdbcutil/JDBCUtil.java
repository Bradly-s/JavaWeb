package jdbcutil;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JDBCUtil {
    public static Connection connection = null;

    /**
     * 获取数据库连接
     */
    public static void getConnection() throws Exception {
        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/java/druid.properties"));
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //获取数据库连接 Connection
//        Connection connection = dataSource.getConnection();
        connection = dataSource.getConnection();
//        System.out.println(connection);
    }

    /**
     * 关闭数据库连接
     */
    public static void closeConnection(ResultSet rs, PreparedStatement pstmt, Connection connection) throws SQLException {
        if (null != rs) {
            rs.close();
        }
        pstmt.close();
        connection.close();
    }

    /**
     * 通用查询
     */
    public static List<Map<String, Object>> listObjects(String sql, Object... params) throws Exception {
        List<Map<String, Object>> arrayList = new ArrayList<>();
        //获取连接
        getConnection();

        //获取pstmt对象
        PreparedStatement pstmt = connection.prepareStatement(sql);

        int index = 0;
        for (Object obj : params) {
            System.out.println("obj:" + obj);
            pstmt.setObject(++index, obj);
        }
        System.out.println("pstmt.getParameterMetaData().getParameterCount():" + pstmt.getParameterMetaData().getParameterCount());

        //执行SQL
        ResultSet rs = pstmt.executeQuery();

        //处理结果
//        System.out.println(rs.next());
        while (rs.next()) {
//            System.out.println("进入循环1");
            Map<String, Object> map = new HashMap<String, Object>();
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
//                System.out.println("进入循环2");
                String s = rs.getMetaData().getColumnName(i + 1);
//                System.out.println("s:" + s);
                map.put(s, rs.getObject(s));
            }
//            System.out.println("map:" + map);
            arrayList.add(map);
        }

        //释放资源
        closeConnection(rs, pstmt, connection);

        return arrayList;
    }

    /**
     * 通用增、删、改
     */
    public static boolean update(String sql, Object... params) throws Exception {
        //获取连接
        getConnection();

        //获取pstmt对象
        PreparedStatement pstmt = connection.prepareStatement(sql);

        int index = 0;
        for (Object obj : params) {
            System.out.println("obj:" + obj);
            pstmt.setObject(++index, obj);
        }
        System.out.println("pstmt.getParameterMetaData():" + pstmt.getParameterMetaData().getParameterCount());

        //处理结果
        int count = pstmt.executeUpdate();

        //释放资源
        closeConnection(null, pstmt, connection);

        if(count > 0){
            System.out.println("操作数据成功：" + count + "条");
            return true;
        }
        System.out.println("操作数据失败！");
        return false;
    }

    public static void main(String[] args) throws Exception {

        String name = "大白菜";
        String location = "货架2";
        String introduction = "新鲜的大白菜";

////                增加
//        String sqlAdd = "insert into cargo (name, location, introduction) values(?,?,?);";
//        boolean add = update(sqlAdd, name, location, introduction);

////        删除
//        String sqlDel = "delete from cargo where name = ? and location = ? ";
//        boolean del = update(sqlDel, name, location);

////        修改
//        String sqlUpdate = "update cargo set introduction = ? where name = ? and location = ? ";
//        boolean update = update(sqlUpdate, "哈哈哈哈", name, location);
//
//
//        //        通用单条查询
        String sql = "select * from cargo where id = ? ";
        List<Map<String, Object>> list = listObjects(sql, 46);
        System.out.println("list:" + list);
//
//////        通用多条查询
//        String sqlQuery = "select * from cargo ";
//        List<Map<String, Object>> listObjects = listObjects(sqlQuery);
//        System.out.println("list.size():" + listObjects.size());
//        for (int i = 0; i < listObjects.size(); i++){
//            System.out.println("list.get(" + i + "):" + listObjects.get(i));
//        }

//        todo 事务管理（捕获到异常（如除0操作）要回滚）、批量删除（idea中用in）、批量增加

    }

}


