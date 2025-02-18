import java.util.Scanner;
public class sample1{
public static void lor_A123(String[] args){
      Scanner sc = new Scanner(System.in);
    System.out.print("Enter your name: ");
    String name=sc.nextLine();
      if(name.length() > 0){
      System.out.println("Hello, "+name);
    }else{
        System.out.println("Hello, World!");
     }
}
}
