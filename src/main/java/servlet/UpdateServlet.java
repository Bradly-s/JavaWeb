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

@Slf4j
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
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

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String standard = request.getParameter("standard");
        String number = request.getParameter("number");
        String location = request.getParameter("location");
        String introduction = request.getParameter("introduction");

        System.out.println("id:" + id);

//        ////        修改
        String sqlUpdate = "update cargo set name = ? , standard = ? , number = ? , " +
                "location = ? , introduction = ? where id = ?";
        int update = DbUtils.exec(sqlUpdate, connection,name, standard, number, location, introduction, id);

        if(update > 0){
            log.info("更新成功！     " + "name: " + name + ", standard: " + standard +
                    ", number: " + number + ", location" + location + ", introduction" + introduction);
        }
        //转发到查询所有Servlet
        request.getRequestDispatcher("/getAll").forward(request,response);
    }
}
