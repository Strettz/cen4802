import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class UserManagementSystem {
    private static final Logger LOGGER = Logger.getLogger(UserManagementSystem.class.getName());
    private List<String> users;

    public UserManagementSystem() {
        this.users = new ArrayList<>();
        setupLogger();
    }

    public void addUser(String user) {
        LOGGER.info("Adding user: " + user);
        if (users.contains(user)) {
            LOGGER.warning("Attempted to add duplicate user: " + user);
        } else {
            users.add(user);
            LOGGER.fine("User added successfully: " + user);
        }
    }

    public void deleteUser(String user) {
        LOGGER.info("Deleting user: " + user);
        if (!users.contains(user)) {
            LOGGER.severe("Attempted to delete non-existent user: " + user);
        } else {
            users.remove(user);
            LOGGER.fine("User deleted successfully: " + user);
        }
    }

    public void listUsers() {
        LOGGER.info("Listing all users");
        if (users.isEmpty()) {
            LOGGER.warning("No users found");
        } else {
            users.forEach(user -> LOGGER.fine("User: " + user));
        }
    }

    private static void setupLogger() {
        LogManager.getLogManager().reset();
        LOGGER.setLevel(Level.ALL);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        LOGGER.addHandler(consoleHandler);

        try {
            FileHandler fileHandler = new FileHandler("UserManagementSystem.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL);
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "File logger not working.", e);
        }
    }

    public static void main(String[] args) {
        UserManagementSystem ums = new UserManagementSystem();
        for (int i = 0; i < 50; i++) {
            String userName = "User" + i;
            ums.addUser(userName);

            // Introduce a duplicate every 10 users to generate a warning
            if (i % 10 == 0) {
                ums.addUser(userName);
            }

            // Delete every 5th user twice to generate a severe log entry
            if (i % 5 == 0) {
                ums.deleteUser(userName);
                ums.deleteUser(userName);
            }
        }

        // List users at the end to generate fine log entries
        ums.listUsers();
    }
}
