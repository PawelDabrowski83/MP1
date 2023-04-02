import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String line = "";
        display(Config.MSG_WELCOME);

        Menu menu = new Menu();

        try (Scanner scanner = new Scanner(System.in)) {
            display(Config.MSG_CHOOSE);
            menu.displayMenuOptions();
            while(!scanner.hasNext()) {

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void display(String message) {
        System.out.println(message);
    }


}
