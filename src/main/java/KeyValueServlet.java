import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KeyValueServlet extends HttpServlet {
    private Map<String, String> keyValueMap;

    @Override
    public void init() throws ServletException {
        super.init();
        // Инициализация коллекции с данными
        keyValueMap = new HashMap<>();
        keyValueMap.put("ключ1", "значение1");
        keyValueMap.put("ключ2", "значение2");
        keyValueMap.put("ключ3", "значение3");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Получение ключа от пользователя
        String searchKey = request.getParameter("key");

        // Поиск значения по ключу
        String value = keyValueMap.getOrDefault(searchKey, "Значение не найдено");

        // Отправка ответа клиенту
        response.setContentType("text/plain");
        response.getWriter().println("Значение для ключа \"" + searchKey + "\": " + value);
    }
}
