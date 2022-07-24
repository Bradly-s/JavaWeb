package jdbcutil;


import lombok.extern.slf4j.Slf4j;
import pojo.CarGo;

import java.sql.Connection;
import java.util.ArrayList;

@Slf4j
public class DbUtilsTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Connection connection = DbUtils.getMySqlConnection();
        Class clazz = CarGo.class;

        String name = "大白菜";
        String location = "货架23444";
        String introduction = "新4444466666";
////                增加
//        String sqlAdd = "insert into cargo (name, location, introduction) values(?,?,?);";
//        int add = DbUtils.exec(sqlAdd, connection, name, location, introduction);
//        if(add > 0){
//            log.info("增加成功！");
//        }

//        ////        删除
//        String sqlDel = "delete from cargo where name = ? and location = ? ";
//        int del = DbUtils.exec(sqlDel, connection, name, location);

//        ////        修改
//        String sqlUpdate = "update cargo set introduction = ? where name = ? and location = ? ";
//        int update = DbUtils.exec(sqlUpdate, connection,"哈哈哈哈", name, location);

//        查询
        String sqlQuery = "select * from cargo";
        ArrayList<CarGo> arrayList = DbUtils.getAll(clazz, sqlQuery, connection);
        log.info(String.valueOf(arrayList.size()));
//        arrayList.forEach(System.out::println);
        for (int i = 0; i < arrayList.size(); i++) {
//            log.info(String.valueOf(arrayList.get(i)).trim());
            System.out.println(arrayList.get(i));
        }
//        log.info("arrayList: " + arrayList);



    }
}
