package task1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/guess")
public class GuessNumberServlet extends HttpServlet {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 100;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        session.setAttribute("min", MIN_NUMBER);
        session.setAttribute("max", MAX_NUMBER);
        session.setAttribute("attempts", 0);

        showPage(response, MIN_NUMBER, MAX_NUMBER, 0, null);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        Integer min = (Integer) session.getAttribute("min");
        Integer max = (Integer) session.getAttribute("max");
        Integer attempts = (Integer) session.getAttribute("attempts");

        if (min == null || max == null) {
            response.sendRedirect("guess");
            return;
        }

        if (attempts == null) {
            attempts = 0;
        }

        String answer = request.getParameter("answer");

        if ("restart".equals(answer)) {
            session.setAttribute("min", MIN_NUMBER);
            session.setAttribute("max", MAX_NUMBER);
            session.setAttribute("attempts", 0);

            showPage(response, MIN_NUMBER, MAX_NUMBER, 0, null);
            return;
        }

        if (!"less".equals(answer)
                && !"equal".equals(answer)
                && !"greater".equals(answer)) {
            showPage(response, min, max, attempts, "Невідома відповідь.");
            return;
        }

        int guess = min + (max - min) / 2;
        attempts++;

        session.setAttribute("attempts", attempts);

        if ("equal".equals(answer)) {
            session.removeAttribute("min");
            session.removeAttribute("max");

            showPage(response, min, max, attempts,
                    "Комп'ютер вгадав число: " + guess
                            + "! Кількість спроб: " + attempts);
            return;
        }

        if ("greater".equals(answer)) {
            min = guess + 1;
        } else {
            max = guess - 1;
        }

        if (min > max) {
            session.removeAttribute("min");
            session.removeAttribute("max");

            showPage(response, min, max, attempts,
                    "Відповіді суперечать одна одній. "
                            + "Почніть нову гру.");
            return;
        }

        session.setAttribute("min", min);
        session.setAttribute("max", max);

        showPage(response, min, max, attempts, null);
    }

    private void showPage(HttpServletResponse response,
                          int min, int max, int attempts, String message)
            throws IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='uk'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Вгадай число</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Гра «Вгадай число»</h1>");
        out.println("<p>Загадайте ціле число від 0 до 100.</p>");

        if (message != null) {
            out.println("<h2>" + message + "</h2>");
        } else if (min <= max) {
            int guess = min + (max - min) / 2;

            out.println("<h2>Ваше число дорівнює " + guess + "?</h2>");

            out.println("<form method='post'>");

            out.println("<button name='answer' value='less'>");
            out.println("Моє число менше");
            out.println("</button>");

            out.println("<button name='answer' value='equal'>");
            out.println("Так, вгадав");
            out.println("</button>");

            out.println("<button name='answer' value='greater'>");
            out.println("Моє число більше");
            out.println("</button>");

            out.println("</form>");

            out.println("<p>Поточний діапазон: " + min + "–" + max + "</p>");
        }

        out.println("<p>Кількість спроб: " + attempts + "</p>");

        if (message != null) {
            out.println("<form method='post'>");
            out.println("<button name='answer' value='restart'>");
            out.println("Почати нову гру");
            out.println("</button>");
            out.println("</form>");
        }

        out.println("<p><a href='quote'>Повернутися до цитати</a></p>");
        out.println("</body>");
        out.println("</html>");
    }
}