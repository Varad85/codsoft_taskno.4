import java.util.*;

public class QuizApplication {
    private static final List<String[]> questionPool = Arrays.asList(
        new String[]{"What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "1"},
        new String[]{"What is the capital of Japan?", "Seoul", "Tokyo", "Beijing", "Bangkok", "2"},
        new String[]{"What is the capital of Australia?", "Sydney", "Melbourne", "Canberra", "Perth", "3"},
        new String[]{"What is the capital of Canada?", "Toronto", "Vancouver", "Ottawa", "Montreal", "3"},
        new String[]{"What is the capital of Brazil?", "Rio de Janeiro", "Brasília", "São Paulo", "Salvador", "2"},
        new String[]{"What is the capital of Germany?", "Berlin", "Munich", "Frankfurt", "Hamburg", "1"},
        new String[]{"What is the capital of Italy?", "Venice", "Milan", "Rome", "Naples", "3"},
        new String[]{"What is the capital of Russia?", "Moscow", "Saint Petersburg", "Kazan", "Novosibirsk", "1"},
        new String[]{"What is the capital of China?", "Shanghai", "Beijing", "Guangzhou", "Shenzhen", "2"},
        new String[]{"What is the capital of India?", "Mumbai", "New Delhi", "Bangalore", "Chennai", "2"}
    );

    private static int score = 0;
    private static final Scanner scanner = new Scanner(System.in);
    private static Timer timer;
    private static boolean isAnswered = false;
    private static boolean isTimeUp = false;
    private static final int timeLimit = 15; // Time limit in seconds for each question
    private static final int questionCount = 5; // Number of questions to ask

    private static final Map<String, User> userMap = new HashMap<>();

}