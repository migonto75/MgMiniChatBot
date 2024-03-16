import de.rhistel.logic.ConsoleReader;

public class Main {
    //region Konstanten
    public static final String APPLIKATION_NAME = "Mg Mini Chat Bot";
    public static final String INPUT_USER_NAME = "\nWie heisst du? ";
    public static final String WELCOME_USER = "\nHerzlich Willkommen ";
    public static final String QUESTION_INPUT_USER = "\nHier sind die Fragen, die du stellen kannst:";
    public static final String ASK_QUESTION = "\nBitte gib eine der oben genannten Fragen ein oder schreib 'Tschüss' zum Beenden:";
    public static final String CHAT_EXIT = "Auf Wiedersehen! Es war schön, mit dir zu plaudern.";
    public static final String GOODBYE = "Tschüss";
    public static final String MISUNDERSTOOD_QUESTION = "\nEntschuldigung, ich verstehe diese Frage nicht.";
    //endregion Konstanten


    //region Variablen
    private static final String[] questions = {
            "Wer bist du?",
            "Wie alt bist du?",
            "Wie heißt du?",
            "Was ist deine Aufgabe?"
    };
    private static final String[] answers = {
            "Ich bin der MiniChatbot.",
            "Ich bin so alt wie die Ausführung des Programms selbst.",
            "Ich heiße Mark Cäsar.",
            "Meine Aufgabe ist es eine Konversation mit meinem Gegenüber zu führen.",
    };
    //endregion Variablen


    //region Methoden
    public static void main(String[] args) {
        startApplikation();
    }

    private static void startApplikation() {
        printApplikationName();
        welcomeUser();
        inputUserQuestion();
    }

    private static void inputUserQuestion() {
        //Fragen ausgeben
        outputQuestions();
        while (true) {
            //Useraufforderung
            System.out.println(ASK_QUESTION);
            String userInput = ConsoleReader.in.readString();
            if (userInput.equalsIgnoreCase(GOODBYE)) {
                System.out.println(CHAT_EXIT);
                break;
            }
            giveAnswere(userInput);
        }
    }

    private static void outputQuestions() {
        System.out.println(QUESTION_INPUT_USER);
        for (String s : questions) {
            System.out.println(s);
        }
    }

    private static void giveAnswere(String input) {
        for (int i = 0; i < questions.length; i++) {
            if (input.equalsIgnoreCase(questions[i])) {
                System.out.println(answers[i]);
                return;
            }
        }
        System.out.println(MISUNDERSTOOD_QUESTION);
    }

    private static void welcomeUser() {
        System.out.println(INPUT_USER_NAME);
        String userName = ConsoleReader.in.readString();
        System.out.println(WELCOME_USER + userName);
    }

    private static void printApplikationName() {
        System.out.println(APPLIKATION_NAME);
    }
    //endregion Methoden
}
