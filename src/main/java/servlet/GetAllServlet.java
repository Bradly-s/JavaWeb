package servlet;

import jdbcutil.DbUtils;
import lombok.extern.slf4j.Slf4j;
import pojo.CarGo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@Slf4j
@WebServlet("/getAll")
public class GetAllServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post...");
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get...");

        Connection connection = DbUtils.getMySqlConnection();
        Class clazz = CarGo.class;

        String sqlQuery = "select * from cargo";
        ArrayList<CarGo> arrayList = DbUtils.getAll(clazz, sqlQuery, connection);

//        保存日志
        log.info(String.valueOf(arrayList.size()));
        log.info("arrayList: " + arrayList);
//        控制台打印
        arrayList.forEach(System.out::println);

        //存入request域中
        request.setAttribute("arrayLists", arrayList);
        //转发到index.jsp
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
