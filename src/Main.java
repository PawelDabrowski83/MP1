import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String line = "";
        display(Config.MSG_WELCOME);

        Map<Integer, String> menu = constructMenu();

        try (Scanner scanner = new Scanner(System.in)) {
            display(Config.MSG_CHOOSE);
            Stream<String> message = menu.values().stream();
            System.out.println(message);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void display(String message) {
        System.out.println(message);
    }

    private static Map<Integer, String> constructMenu() {
        int menuCounter = 0;
        Map<Integer, String> menu = new HashMap<>();
        menu.put(menuCounter, formatMenuItem(Config.OPTION_QUIT, menuCounter++));
        menu.put(menuCounter, formatMenuItem(Config.OPTION_GENERATE, menuCounter++));
        menu.put(menuCounter, formatMenuItem(Config.OPTION_CLEAR, menuCounter++));
        menu.put(menuCounter, formatMenuItem(Config.OPTION_LOAD, menuCounter++));
        menu.put(menuCounter, formatMenuItem(Config.OPTION_SAVE, menuCounter));
        return menu;
    }

    private static String formatMenuItem(String menuItem, int menuNumber) {
        return String.format(menuItem, menuNumber);
    }
}
