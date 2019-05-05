package com.ts.mybatis01.servlet;

import com.ts.mybatis01.bean.Message;
import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp)
        List<Message> list = new ArrayList<Message>();
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建连接对象
            Connection  connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis01?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","123456");
            String sql = "select ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE";//这里不* ，*会影响查询效率
            //3.创建properStatement对象
            PreparedStatement statement = connection.prepareStatement(sql);
            //4.执行查询
            ResultSet resultSet = statement.executeQuery();
            //5.封装结果集
            while (resultSet.next()){
                Message message = new Message();
                message.setId(resultSet.getString("ID"));
                message.setCommand(resultSet.getString("COMMAND"));
                message.setContent(resultSet.getString("CONTENT"));
                message.setDescription(resultSet.getString("DESCRIPTION"));
                list.add(message);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("messageList",list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
