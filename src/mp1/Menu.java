package mp1;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static mp1.Config.MenuOptions.*;
import static mp1.Utils.display;
import static mp1.Config.MenuOptions;


public class Menu {
    Map<Integer, MenuOptions> options = new HashMap<>();
    int menuCounter = 0;

    public Menu() {
        constructMenu();
        runMenu();
    }

    private void constructMenu() {
        addPositionToMenu(QUIT, GENERATE);
    }

    private void addPositionToMenu(MenuOptions... menuOptions) {
        for (MenuOptions option : menuOptions) {
            addPositionToMenu(option);
        }
    }

    private void addPositionToMenu(MenuOptions option) {
        options.put(menuCounter++, option);
    }

    public void displayMenuOptions() {
        display("");
        display(Config.MSG_CHOOSE);
        String message = options.entrySet().stream().map((k) -> String.format("%d -> %s%n", k.getKey(), k.getValue().message)).collect(Collectors.joining(""));
        display(message);
    }

    public void runMenu() {
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

                switch (Objects.requireNonNull(option)) {
                    case LOAD -> appLoad();
                    case GENERATE -> appGenerate();
                    case SAVE -> appSave();
                    case CLEAR -> appClear();
                    case SHOW -> appShowExt();
                    case INVALID -> appInvalid();
                }
                displayMenuOptions();
            }

        } catch (Exception e) {
            display(e.getMessage());
        }
        appQuit();
    }

    private void appQuit() {
        display(Config.MSG_QUIT);
    }

    private void appLoad() {
        display(Config.MSG_LOAD);
    }

    private void appSave() {
        display(Config.MSG_SAVE);
    }

    private void appGenerate() throws Exception {
        Person p1 = new Person("Janina", "Atłas");
        Person p2 = new Person("Karolina", "Buzdygan");
        Person p3 = new Person("Teresa", "Cicholas");
        Person p4 = new Person("Andrzej", "Duda");
        Book b1 = new Book("Anathema",
                new Person[] { p1},
                null, null, null);
        Book b2 = new Book("Biblia w obrazkach",
                new Person[] { p1, p2},
                p4, LocalDateTime.of(2023, 1,1, 14, 30), null);
        Book b3 = new Book("Czy mnie widać? Poradnik",
                new Person[] {p1},
                p4, LocalDateTime.of(2019, 4, 4, 12, 29),
                LocalDateTime.of(2022, 1, 2, 12, 0));
        Book b4 = new Book("Dać czy nie dać", new Person[]{p1, p2});
        Book b5 = new Book("E=mc2", new Person[]{p3},
                p4, LocalDateTime.of(2020, 4, 2, 8, 0), LocalDateTime.now());




        display(Config.MSG_GENERATE);

        addMenuOption(SHOW);


    }

    private void appClear() {
        display(Config.MSG_CLEAR);
    }

    private void appInvalid() {
        display(INVALID.message);
    }


    private void appShowExt() throws Exception {
        Person.showExtent(Person.class);
        Book.showExtent(Book.class);
    }

    private void addMenuOption(MenuOptions option) {
        if (!options.containsValue(option)) {
            addPositionToMenu(option);
        }
    }
}
