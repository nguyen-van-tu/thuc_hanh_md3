package controller;

import model.Product;
import service.IProduct;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet_Search")
public class Servlet_Search extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");

        IProduct iProduct = new ProductService();
        List<Product> lists = null;

        if (search != null){
//            lists = iProduct.findByName(search);
        }else{
            lists = iProduct.findAll();
        }

        req.setAttribute("lists", lists);
        RequestDispatcher dispatcher = req.getRequestDispatcher( "list.jsp");
        dispatcher.forward(req, resp);
    }
    }

