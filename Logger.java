import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static List<String> logs = new ArrayList<>();

    public static void log(String message) {
        logs.add("[LOG] " + message);
    }

    public static void showLogs() {
        System.out.println("\n📜 System Logs:");
        if (logs.isEmpty()) {
            System.out.println("There Are no Recordings...");
        } else {
            for (String log : logs) {
                System.out.println(log);
            }
        }
    }

}