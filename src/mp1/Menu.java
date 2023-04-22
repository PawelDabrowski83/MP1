package mp1;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static mp1.Config.*;
import static mp1.Config.MenuOptions.*;
import static mp1.Utils.display;
import static mp1.MenuService.*;


public class Menu {
    private final MenuService MENU_SERVICE = new MenuService(this);

    Map<Integer, MenuOptions> options = new HashMap<>();
    int menuCounter = 0;

    public Menu() {
        constructMenu();
        runMenu();
    }

    private void constructMenu() {
        addPositionToMenu(QUIT, GENERATE, LOAD, SHOW);
    }

    private void addPositionToMenu(MenuOptions... menuOptions) {
        for (MenuOptions option : menuOptions) {
            addPositionToMenu(option);
        }
    }

    private void addPositionToMenu(MenuOptions option) {
        options.put(menuCounter++, option);
    }

    protected void removePositionToMenu(MenuOptions option) {
        int optionIndex = findOptionIndex(option);
        if (optionIndex < 0) {
            return;
        }
        options.remove(optionIndex);
        if (optionIndex + 1 == menuCounter) {
            menuCounter--;
        }
    }

    private int findOptionIndex(MenuOptions option) {
        return options.entrySet().stream()
                .filter((k) -> option.equals(k.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
    }

    public void displayMenuOptions() {
        display("");
        display(Config.MSG_CHOOSE);
        String message = options.entrySet().stream().map((k) -> String.format("%d -> %s%n", k.getKey(), k.getValue().message)).collect(Collectors.joining(""));
        display(message);
    }

    public void runMenu() {
        display(Config.MSG_WELCOME);
        MenuOptions option = null;
        try (Scanner scanner = new Scanner(System.in)) {

             displayMenuOptions();
            while(!QUIT.equals(option)) {

                String line = scanner.nextLine();
                try {
                    option = options.get(Integer.parseInt(line));
                } catch (NumberFormatException | NullPointerException | IndexOutOfBoundsException e) {
                    option = INVALID;
                    display(option.message);
                }

                MENU_SERVICE.executeOption(option);
                displayMenuOptions();
            }

        } catch (Exception e) {
            display(e.getMessage());
        }
        MENU_SERVICE.appQuit();
    }



    protected void addMenuOption(MenuOptions option) {
        if (!options.containsValue(option)) {
            addPositionToMenu(option);
        }
    }
}
