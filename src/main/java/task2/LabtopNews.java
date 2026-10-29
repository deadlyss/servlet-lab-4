package task2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/lenovo/news")
public class LabtopNews extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='uk'>");
        out.println("<head><meta charset='UTF-8'>");
        out.println("<title>Новини Lenovo</title></head>");
        out.println("<body>");

        out.println("<h1>Новини Lenovo</h1>");

        out.println("<h2>Ноутбуки для роботи та навчання</h2>");
        out.println("<img src='" + request.getContextPath()
                + "/images/thinkpad.png' "
                + "alt='Ноутбук Lenovo ThinkPad' width='400'>");
        out.println("<p>Лінійка ThinkPad орієнтована на професійне "
                + "використання, продуктивність і зручність роботи.</p>");

        out.println("<h2>Ноутбуки для повсякденного використання</h2>");
        out.println("<img src='" + request.getContextPath()
                + "/images/lenovo-yoga.png' "
                + "alt='Ноутбук Lenovo Yoga' width='400'>");
        out.println("<p>Пристрої серії Yoga поєднують портативність, "
                + "сучасний дизайн і функції для роботи та творчості.</p>");

        out.println("<p><a href='../lenovo'>Повернутися до меню</a></p>");

        out.println("</body></html>");
    }
}
