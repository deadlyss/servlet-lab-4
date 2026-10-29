
package task1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/multiplication")
public class MultiplicationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='uk'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Таблиця множення</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Таблиця множення</h1>");

        out.println("<form method='post'>");
        out.println("<label>Введіть число: </label>");
        out.println("<input type='number' name='number' required>");
        out.println("<button type='submit'>Показати</button>");
        out.println("</form>");

        out.println("<p><a href='quote'>Перейти до цитати</a></p>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String input = request.getParameter("number");

        out.println("<!DOCTYPE html>");
        out.println("<html lang='uk'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Результат множення</title>");
        out.println("</head>");
        out.println("<body>");

        try {
            int number = Integer.parseInt(input);

            out.println("<h1>Таблиця множення числа " + number + "</h1>");
            out.println("<table border='1' cellpadding='8'>");

            for (int i = 1; i <= 10; i++) {
                out.println("<tr>");
                out.println("<td>" + number + " × " + i + "</td>");
                out.println("<td>" + (number * i) + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
        } catch (NumberFormatException e) {
            out.println("<p>Будь ласка, введіть ціле число.</p>");
        }

        out.println("<p><a href='multiplication'>Повернутися до введення числа</a></p>");
        out.println("<p><a href='quote'>Повернутися до цитати</a></p>");

        out.println("</body>");
        out.println("</html>");
    }
}
