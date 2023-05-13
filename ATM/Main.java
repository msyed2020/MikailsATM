import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        OptionMenu optionMenu = new OptionMenu();
        intro();
        optionMenu.mainMenu();
    }

    public static void intro() {
        System.out.println("Welcome to Mikail's ATM");
    }
}
