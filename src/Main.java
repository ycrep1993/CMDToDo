import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    new Main().run();
    }

    Administration admin = new Administration();

    /**
     * Run the program
     */
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
                    System.out.println("This is not a valid option... please try again.");
            }
        }
    }

    /**
     * print the main menu
     */
    public void printMenu(){
        System.out.println("--------------------------------------------------");
        System.out.println("(1) ToDo's");
        System.out.println("(2) Configure Settings");
        System.out.println("(-1) Exit program");
        System.out.println("--------------------------------------------------");
    }

    /**
     * the menu for managing to do items
     */
    public void toDoMgmt(){

        int keuze = 0;

        while(keuze != -1){

            printToDos();

            System.out.println("--------------------------------------------------");
            System.out.println("What do you want to do?");
            System.out.println("(1) Add a ToDo");
            System.out.println("(2) Mark a ToDo as Done");
            System.out.println("(3) Delete a ToDo");
            System.out.println("(-1) Go back");
            System.out.println("--------------------------------------------------");
            System.out.println("Enter a menu option: ");

            Scanner sc = new Scanner(System.in);

            try{
                keuze = sc.nextInt();
            }catch(InputMismatchException ime){
                System.out.println(ime.toString());
            }

            switch(keuze){
                case 1: addToDo();
                    break;
                case 2: markAsDone();
                    break;
                case 3: delToDo();
                    break;
                case -1:
                    System.out.println("You will go back to the main menu");
                    break;
                default:
                    System.out.println("Not a valid choice, please try again");
            }
        }

    }

    /**
     * the menu for managing settings
     */
    public void settings(){
        //TODO implement method
    }

    /**
     * print all to do items with a counter
     */
    public void printToDos(){
        ArrayList<ToDo> toDos = admin.getToDos();
        int counter = 0;
        for(ToDo t : toDos){
            System.out.println(counter + " " + t.toString());
            counter++;
        }
    }

    /**
     * add a new to do item
     */
    public void addToDo(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter what you should do");

        String todoDescription = sc.nextLine();

        admin.addToDoToList(todoDescription);

        System.out.println("Todo added");
        System.out.println();
    }

    /**
     * mark a to do item as done
     */
    public void markAsDone(){
        System.out.println("Enter the number of the item that should be marked as done");

        Scanner sc = new Scanner(System.in);

        int index;

        try{
            index = sc.nextInt();

            admin.setDone(index);

        }catch(InputMismatchException ime){
            System.out.println(ime.toString());
        }
    }

    /**
     * delete a to do item
     */
    public void delToDo(){
        System.out.println("Enter the number of the item that should be deleted");

        Scanner sc = new Scanner(System.in);

        int keuze;

        try{
            keuze = sc.nextInt();
            admin.removeToDoItem(keuze);
        }catch(InputMismatchException ime){
            System.out.println(ime.toString());
        }

        System.out.println("Todo deleted");
    }
}
