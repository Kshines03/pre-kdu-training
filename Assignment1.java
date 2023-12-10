import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        String FirstString = scn.nextLine();

        String SecondString = scn.nextLine();

        scn.close();
        
        System.out.println("Length of the first string: " + FirstString.length());

        System.out.println("Length of the second string: " + SecondString.length());


        if (FirstString.length() == SecondString.length()) {
            System.out.println("The length of the two strings are the same");
        } else {
            System.out.println("The lengths of the two strings is not the same");
        }

        if (FirstString.equals(SecondString)) {
            System.out.println("Two strings are equal");
        } else {
            System.out.println("Two strings are not equal");
        }

    }
}