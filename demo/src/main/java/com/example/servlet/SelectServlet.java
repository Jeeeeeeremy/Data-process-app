package com.example.servlet;

import com.example.entity.Item;
import com.example.service.ItemService;
import com.example.serviceimpl.ItemServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "SelectServlet", value = "/select-servlet")
public class SelectServlet extends HttpServlet {
    /*doget方法*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        ItemService itemservice = new ItemServiceImpl();
        ArrayList<Item> items  =  (ArrayList<Item>)itemservice.queryallitem();
        JSONArray json = JSONArray.fromObject(items);
        out.println(json.toString());
        out.flush();
        out.close();
    }
    /*dopost方法*/
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
