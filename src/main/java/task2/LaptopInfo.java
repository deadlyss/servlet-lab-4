package task2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/lenovo/info")
public class LaptopInfo extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='uk'>");
        out.println("<head><meta charset='UTF-8'>");
        out.println("<title>Про Lenovo</title></head>");
        out.println("<body>");

        out.println("<h1>Загальна інформація</h1>");
        out.println("<h2>Lenovo Group Limited</h2>");

        out.println("<img src='" + request.getContextPath() +
                "/images/lenovo-logo.png' " +
                "alt='Логотип Lenovo' width='200'>");

        out.println("<p><b>Країна штаб-квартири:</b> Китай "
                + "(Пекін)</p>");

        out.println("<p><b>Кількість співробітників:</b> "
                + "понад 70 000 (орієнтовно; залежить від звітного періоду)</p>");

        out.println("<p>Lenovo — міжнародна технологічна компанія, "
                + "яка розробляє та виробляє персональні комп'ютери, "
                + "ноутбуки, сервери, планшети та інші електронні пристрої. "
                + "До відомих лінійок ноутбуків належать ThinkPad, "
                + "ThinkBook, Yoga та IdeaPad.</p>");

        out.println("<p><a href='../lenovo'>Повернутися до меню</a></p>");

        out.println("</body></html>");
    }
}
