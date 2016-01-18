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
        }
    }

    public void printMenu(){
        System.out.println("--------------------------------------------------");
        System.out.println("(1) Show all ToDo's");
        System.out.println("(2) Add a new ToDo");
        System.out.println("(3) Change ToDo File");

    }
}
