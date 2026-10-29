
package task1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='uk'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Калькулятор трьох чисел</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Обчислення для трьох чисел</h1>");

        out.println("<form method='post'>");

        out.println("<p>Перше число: <input type='number' step='any' name='n1' required></p>");
        out.println("<p>Друге число: <input type='number' step='any' name='n2' required></p>");
        out.println("<p>Третє число: <input type='number' step='any' name='n3' required></p>");

        out.println("<h3>Оберіть операцію:</h3>");

        out.println("<p><input type='radio' name='operation' value='max' required> Максимум</p>");
        out.println("<p><input type='radio' name='operation' value='min'> Мінімум</p>");
        out.println("<p><input type='radio' name='operation' value='avg'> Середнє арифметичне</p>");

        out.println("<button type='submit'>Обчислити</button>");
        out.println("</form>");

        out.println("<p><a href='quote'>Повернутися до цитати</a></p>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='uk'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Результат обчислення</title>");
        out.println("</head>");
        out.println("<body>");

        try {
            double n1 = Double.parseDouble(request.getParameter("n1"));
            double n2 = Double.parseDouble(request.getParameter("n2"));
            double n3 = Double.parseDouble(request.getParameter("n3"));

            String operation = request.getParameter("operation");
            double result;

            switch (operation == null ? "" : operation) {
                case "max":
                    result = Math.max(n1, Math.max(n2, n3));
                    out.println("<h2>Максимум: " + result + "</h2>");
                    break;

                case "min":
                    result = Math.min(n1, Math.min(n2, n3));
                    out.println("<h2>Мінімум: " + result + "</h2>");
                    break;

                case "avg":
                    result = (n1 + n2 + n3) / 3.0;
                    out.println("<h2>Середнє арифметичне: " + result + "</h2>");
                    break;

                default:
                    out.println("<p>Оберіть операцію.</p>");
                    break;
            }

        } catch (NumberFormatException e) {
            out.println("<p>Введіть коректні числові значення.</p>");
        }

        out.println("<p><a href='calculator'>Повернутися до калькулятора</a></p>");

        out.println("</body>");
        out.println("<p><a href='quote'>Повернутися до цитати</a></p>");
        out.println("</html>");
    }
}
