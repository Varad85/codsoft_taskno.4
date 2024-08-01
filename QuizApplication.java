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

    public static void main(String[] args) {
        while (true) {
            String userName = getUserName();
            User currentUser = userMap.getOrDefault(userName, new User(userName));

            showRules();
            if (!getUserConsent()) {
                System.out.println("Come back next time!");
                break;
            }
            score = 0; // Reset score for new game
            System.out.println("Starting the Quiz!");

            List<String[]> questions = getRandomQuestions(questionCount);
            for (String[] question : questions) {
                presentQuestion(question);
            }

            currentUser.incrementAttempts();
            currentUser.addScore(score);
            userMap.put(userName, currentUser);

            displayResult(questions, currentUser);

            if (!getUserConsentForReplay()) {
                System.out.println("Thank you for playing!");
                break;
            }
    }
}

private static String getUserName() {
    System.out.print("Enter your first name: ");
    String firstName = scanner.next();
    System.out.print("Enter your last name: ");
    String lastName = scanner.next();
    return (firstName + " " + lastName).toLowerCase();
}

private static void showRules() {
    System.out.println("Quiz Rules:");
    System.out.println("- This quiz is about capitals of countries.");
    System.out.println("- You have 15 seconds to answer each question.");
    System.out.println("- There are 5 questions in total.");
    System.out.println("-Answering each question is mandatory.");
    System.out.println("-Next question won't be displayed until you select an option for current question.");
    System.out.println("-If user selects option after 15 seconds,that answer will not be evaluated.");
    System.out.println("- Your final score will be displayed at the end of the quiz.");
    System.out.print("Do you want to continue? (yes/no): ");
}
}