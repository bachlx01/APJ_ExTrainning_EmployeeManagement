import controller.Controller;
import view.UserInterface;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = UserInterface.getInstance();

       if (userInterface.login()) {
           Controller controller = new Controller();

           while (true) {
               userInterface.showMenu();
               controller.execute(userInterface.prompt("Enter your choice: "));
           }
       }

    }
}
