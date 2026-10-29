package task2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/lenovo/models")
public class LaptopModels extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='uk'>");
        out.println("<head><meta charset='UTF-8'>");
        out.println("<title>Моделі ноутбуків Lenovo</title></head>");
        out.println("<body>");

        out.println("<h1>Моделі ноутбуків Lenovo</h1>");

        out.println("<h2>Lenovo ThinkPad X1 Carbon</h2>");
        out.println("<img src='" + request.getContextPath()
                + "/images/thinkpad.png' "
                + "alt='Ноутбук Lenovo ThinkPad' width='400'>");
        out.println("<p>Легкий бізнес-ноутбук для професійної роботи "
                + "та мобільного використання.</p>");

        out.println("<h2>Lenovo Yoga 9i</h2>");
        out.println("<img src='" + request.getContextPath()
                + "/images/yoga9i.png' "
                + "alt='Ноутбук Lenovo ThinkPad' width='400'>");
        out.println("<p>Універсальний ноутбук-трансформер для роботи, "
                + "навчання та мультимедіа.</p>");

        out.println("<h2>Lenovo IdeaPad Slim 5</h2>");
        out.println("<img src='" + request.getContextPath()
                + "/images/ideapad5.png' "
                + "alt='Ноутбук Lenovo ThinkPad' width='400'>");
        out.println("<p>Ноутбук для повсякденних завдань, навчання "
                + "та офісних програм.</p>");

        out.println("<p><a href='../lenovo'>Повернутися до меню</a></p>");

        out.println("</body></html>");
    }
}
