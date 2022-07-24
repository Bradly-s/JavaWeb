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
@WebServlet("/delServlet")
public class DelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()中get....");
        //接收id
        String id = request.getParameter("id");
        System.out.println("参数id：" + id);

        Connection connection = DbUtils.getMySqlConnection();

        //        ////        删除
        String sqlDel = "delete from cargo where id = ?";
        int del = DbUtils.exec(sqlDel, connection, id);
        if(del > 0){
            log.info("删除成功！");
        }
        //转发到查询所有Servlet
        request.getRequestDispatcher("/getAll").forward(request,response);
    }
}
