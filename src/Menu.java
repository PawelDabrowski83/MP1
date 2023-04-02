import java.util.HashMap;
import java.util.Map;

public class Menu {
    Map<Integer, String> options = new HashMap<>();
    int menuCounter = 0;

    public Menu() {
        constructMenu();
    }

    private void constructMenu() {
        addPositionToMenu(
                new String[]
                        {Config.OPTION_QUIT, Config.OPTION_GENERATE,
                        Config.OPTION_LOAD}
        );
    }

    private void addPositionToMenu(String[] message) {
        for (String s : message) {
            options.put(menuCounter, formatMenuItem(s, menuCounter++));
        }

    }

    private static String formatMenuItem(String menuItem, int menuNumber) {
        return String.format(menuItem, menuNumber);
    }

    public void displayMenuOptions() {
        Main.display(
                String.join(
                        "\n", options.values()
                )
        );
    }
}
