import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    new Main().run();
    }

    public void run(){
        int keuze = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the command line version of Simple To Do");
        System.out.println("---------------------------------------------------");
        System.out.println("");
        System.out.println("What do you want to do?");
        System.out.println("");

        while(keuze != -1){
            printMenu();

            System.out.println("Enter a menu option: ");
            try{
                keuze = sc.nextInt();
            }catch (InputMismatchException ime){
                System.out.println("You should enter a valid integer as a menu option");
            }

            switch (keuze){
                case 1: toDoMgmt();
                    break;
                case 2: settings();
                    break;
                case -1:
                    System.out.println("Thanks for using Simple To Do, see you next time!");
                    break;
                default:
                    System.out.println("This is not a valid option... please try again");
            }
        }
    }

    public void printMenu(){
        System.out.println("--------------------------------------------------");
        System.out.println("(1) Manage ToDo's");
        System.out.println("(2) Configure Settings");
        System.out.println("(-1) Exit program");
        System.out.println("--------------------------------------------------");
    }
}
