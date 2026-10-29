package task1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/quote")
public class QuoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Martin Fowler Quote</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Martin Fowler</h2>");
        out.println("<p>Any fool can write code that a computer can understand.</p>");
        out.println("<p>Good programmers write code that humans can understand.</p>");
        out.println("</body>");
        out.println("<p><a href='multiplication'>Перейти до таблиці множення</a></p>");
        out.println("<p><a href='guess'>Грати у «Вгадай число»</a></p>");
        out.println("<p><a href='calculator'>Калькулятор трьох чисел</a></p>");
        out.println("<p><a href='lenovo'>Вебсайт виробника ноутбуків</a></p>");
        out.println("</html>");
    }
}