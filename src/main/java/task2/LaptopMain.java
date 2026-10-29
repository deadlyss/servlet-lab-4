package task2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/lenovo")
public class LaptopMain extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='uk'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Lenovo — головна сторінка</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Lenovo</h1>");
        out.println("<h2>Виробник ноутбуків і комп'ютерної техніки</h2>");

        out.println("<h3>Меню</h3>");
        out.println("<ul>");
        out.println("<li><a href='lenovo/info'>Загальна інформація</a></li>");
        out.println("<li><a href='lenovo/news'>Новини</a></li>");
        out.println("<li><a href='lenovo/models'>Моделі ноутбуків</a></li>");
        out.println("</ul>");

        out.println("<p><a href='quote'>Повернутися до попередніх завдань</a></p>");

        out.println("</body>");
        out.println("</html>");
    }
}
