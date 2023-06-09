package mp1;

public class Config {

    enum MenuOptions {
        GENERATE(OPTION_GENERATE),
        LOAD(OPTION_LOAD),
        SAVE(OPTION_SAVE),
        CLEAR(OPTION_CLEAR),
        QUIT(OPTION_QUIT),
        SHOW(OPTION_SHOW_EXT),
        INVALID(ERR_BAD_INPUT);

        String message;

        MenuOptions(String message) {
            this.message = message;
        }
    }
    public static final String FILENAME = "mp1.obj";
    public static final String MSG_WELCOME = "Open program.";

    public static final String MENU_PREFIX = "%d - ";

    public static final String OPTION_GENERATE = "Generate sample data for demonstration.";
    public static final String MSG_GENERATE = "Sample data generated.";

    public static final String OPTION_LOAD = "Load data from file.";
    public static final String MSG_LOAD = "Data loaded.";

    public static final String OPTION_SAVE = "Save data to file.";
    public static final String MSG_SAVE = "Data saved.";

    public static final String OPTION_CLEAR = "Clear data from the program.";
    public static final String MSG_CLEAR = "Data erased from memory.";

    public static final String OPTION_QUIT = "Quit program.";
    public static final String MSG_QUIT = "Bye.";
    public static final String MSG_CHOOSE = "Enter number to pick option.";
    public static final String ERR_BAD_INPUT = "Incorrect input. Only numbers are allowed here.";
    public static final String ERR_EMPTY = "Database is empty. Consider generating sample data for demonstration.";
    public static final String ERR_SAVE = "Saving error.";
    public static final String ERR_LOAD = "Loading error.";
    public static final String OPTION_SHOW_EXT = "Show extension.";
    public static final String MSG_SHOW_EXTENT = "Show extent:";


}
