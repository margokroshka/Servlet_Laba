import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.HashMap;
        import java.util.Map;
        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
    private Map<String, Integer> wordFrequencyMap;

    @Override
    public void init() throws ServletException {
        super.init();
        // Загрузка текстового файла и определение частоты встречаемости слов
        wordFrequencyMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\NT\\OneDrive\\Desktop\\Servlet_Laba\\src\\main\\resources\\wordDB.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Получение слова от пользователя
        String searchWord = request.getParameter("word");

        // Поиск и определение частоты встречаемости слова
        int frequency = wordFrequencyMap.getOrDefault(searchWord, 0);

        // Отправка ответа клиенту
        response.setContentType("text/plain");
        response.getWriter().println("Частота встречаемости слова \"" + searchWord + "\": " + frequency);
    }
}
