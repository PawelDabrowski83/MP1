package mp1;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static mp1.Config.*;
import static mp1.Config.MenuOptions.*;
import static mp1.Utils.display;

public class MenuService {
    private static Menu MENU;

    public MenuService(Menu menu) {
        MENU = menu;
    }

    protected void executeOption(Config.MenuOptions option) throws Exception {
        switch (Objects.requireNonNull(option)) {
            case LOAD -> appLoad();
            case GENERATE -> appGenerate();
            case SAVE -> appSave();
            case CLEAR -> appClear();
            case SHOW -> appShowExt();
            case INVALID -> appInvalid();
        }

    }
    protected void appQuit() {
        display(Config.MSG_QUIT);
    }

    protected void appLoad() {
        try {
            ObjectPlus.readExtents(
                    new ObjectInputStream(
                            new FileInputStream(Config.FILENAME)
                    )
            );
        } catch (IOException | ClassNotFoundException ignored) {
            display(ERR_LOAD);
        }
        display(Config.MSG_LOAD);
        MENU.addMenuOption(CLEAR);
        MENU.addMenuOption(SAVE);
    }

    protected void appSave() {
        try {
            ObjectPlus.writeExtents(
                    new ObjectOutputStream(
                            new FileOutputStream(Config.FILENAME)
                    )
            );
        } catch (IOException ignored) {
            display(ERR_SAVE);
        }
        display(Config.MSG_SAVE);

    }

    protected void appGenerate() throws Exception {
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

        MENU.addMenuOption(CLEAR);
        MENU.addMenuOption(SAVE);


    }

    protected void appClear() {
        ObjectPlus.removeAllExtents();
        display(Config.MSG_CLEAR);
        MENU.removePositionToMenu(CLEAR);
    }

    protected void appInvalid() {
        display(INVALID.message);
    }


    protected void appShowExt() throws Exception {
        display(MSG_SHOW_EXTENT);
        ObjectPlus.showAllExtents();
    }
}
