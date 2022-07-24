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
@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()中get....");

        String id = request.getParameter("id");
        System.out.println("参数id：" + id);

        Connection connection = DbUtils.getMySqlConnection();
        Class clazz = CarGo.class;
        String sqlQuery = "select * from cargo where cargo.id = ?" ;
        CarGo carGo = (CarGo) DbUtils.getOneByCondition(clazz, sqlQuery, connection, id);

        System.out.println(carGo.getId() + " " + carGo.getName() + " " + carGo.getStandard()
                            + " " + carGo.getNumber() + " " + carGo.getLocation() + " " + carGo.getIntroduction());
        log.info("查询数据：" + carGo.getId() + " " + carGo.getName() + " " + carGo.getStandard()
                + " " + carGo.getNumber() + " " + carGo.getLocation() + " " + carGo.getIntroduction());

        request.setAttribute("carGo", carGo);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }
}
