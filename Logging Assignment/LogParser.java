import java.io.*;

public class LogParser {
    public static void main(String[] args) {
        String logFile = "UserManagementSystem.log";
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("WARNING") || line.contains("SEVERE")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
