import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TextFragmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Получение параметров размера шрифта и количества строк
        int fontSize = Integer.parseInt(request.getParameter("fontSize"));
        int numLines = Integer.parseInt(request.getParameter("numLines"));

        // Генерация текстового фрагмента с заданными параметрами
        StringBuilder textFragment = new StringBuilder();
        for (int i = 1; i <= numLines; i++) {
            textFragment.append("<p style=\"font-size:").append(fontSize).append("px;\">")
                    .append("Фрагмент текста со шрифтом размером ").append(fontSize).append("px (строка ").append(i).append(")")
                    .append("</p>");
        }

        // Передача фрагмента текста на JSP-страницу
        request.setAttribute("textFragment", textFragment.toString());
        request.getRequestDispatcher("textfragment.jsp").forward(request, response);
    }
}

