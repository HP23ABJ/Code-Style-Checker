import java.util.Scanner;

public class SampleCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        String userName = sc.nextLine();

        if (userName.length() > 0) {
            printGreeting(userName);
        } else {
            printGreeting("World!");
        }
    }

    public static void PrintGreeting(String Name) {
        System.out.println("Hello, " + Name);
    }

    public static void DoSomethingImportant() {
        System.out.println("Doing something important!");
    }

    // TODO: Implement the save functionality
    public static void saveData(String data) {
        // To be done later
    }
}
