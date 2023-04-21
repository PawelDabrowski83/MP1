package mp1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static mp1.Utils.display;


public class Menu {
    Map<Integer, String> options = new HashMap<>();
    int menuCounter = 0;

    public Menu() {
        constructMenu();
        runMenu();
    }

    private void constructMenu() {
        addPositionToMenu(
                new String[]
                        {Config.OPTION_QUIT,
                        Config.OPTION_GENERATE,
                        Config.OPTION_LOAD}
        );
    }

    private void addPositionToMenu(String[] message) {
        for (String s : message) {
            options.put(menuCounter++, s);
        }

    }

    public void displayMenuOptions() {
        display("");
        display(Config.MSG_CHOOSE);
        String message = options.entrySet().stream().map((k) -> String.format("%d -> %s%n", k.getKey(), k.getValue())).collect(Collectors.joining(""));
        display(message);
    }

    public void runMenu() {
        String option = null;
        try (Scanner scanner = new Scanner(System.in)) {

             displayMenuOptions();
            while(!Config.OPTION_QUIT.equals(option)) {

                String line = scanner.nextLine();
                try {
                    option = options.get(Integer.parseInt(line));
                } catch (NumberFormatException | NullPointerException | IndexOutOfBoundsException e) {
                    display(Config.ERR_BAD_INPUT);
                    option = "";
                }

                if (option == null) {
                    option = "";
                }
                switch (Objects.requireNonNull(option)) {
                    case Config.OPTION_LOAD -> appLoad();
                    case Config.OPTION_GENERATE -> appGenerate();
                    case Config.OPTION_SAVE -> appSave();
                    case Config.OPTION_CLEAR -> appClear();
                    case Config.OPTION_SHOW_EXT -> appShowExt();
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
        display(Config.MSG_GENERATE);

        if (!options.containsValue(Config.OPTION_SHOW_EXT)) {
            addPositionToMenu(new String[] { Config.OPTION_SHOW_EXT });
        }

    }

    private void appClear() {
        display(Config.MSG_CLEAR);
    }

    private void appShowExt() throws Exception {
        Person.showExtent(Person.class);
    }
}
