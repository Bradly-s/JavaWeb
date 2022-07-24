package servlet;

import jdbcutil.DbUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

@Slf4j
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()中get....");
        Connection connection = DbUtils.getMySqlConnection();
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");

        //获取所有参数的Map集合
        Map<String, String[]> map = request.getParameterMap();
        for (String key : map.keySet()) {
            System.out.print(key+":");
            //获取值
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        String name = request.getParameter("name");
        String standard = request.getParameter("standard");
        String number = request.getParameter("number");
        String location = request.getParameter("location");
        String introduction = request.getParameter("introduction");

////                增加
        String sqlAdd = "insert into cargo (name, standard, number, location, introduction) values(?,?,?,?,?)";
        int add = DbUtils.exec(sqlAdd, connection, name, standard, number, location, introduction);
        if(add > 0){
            log.info("增加成功！     " + "name: " + name + ", standard: " + standard +
                    ", number: " + number + ", location" + location + ", introduction" + introduction);
        }
        //转发到查询所有Servlet
        request.getRequestDispatcher("/getAll").forward(request,response);
    }
}
