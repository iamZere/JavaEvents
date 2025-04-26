import java.util.Scanner;

public class PruebaLuhn {

public static void main(String[] args) {
    System.out.println("main() : Entry Point");

    Scanner input = new Scanner(System.in);

    long num;
    double digit = 0;
    int sum = 0;
    int n = 1;
    int i = 0;
    System.out.println("Enter the digits of a credit card number : ");
    num = input.nextLong();

    while (num > 0) {
        digit = num % 10;
        num = num / 10;

        System.out.println(n + " digit is : " + digit);

        if (i % 2 != 0 ) {
            digit *= 2;
        }

        System.out.println(n + " digit is : " + digit);

        if (digit > 9) {
            digit = (digit % 10) + 1;
        }
        else 
            digit *= 1;

        System.out.println(n + " digit is : " + digit);

        sum += digit;
        n++;
        i++;
    }

    System.out.println("Sum of the digits is : " +sum);

    if(sum % 10 == 0) {
        System.out.println("Credit card number is valid.");
    }
    else 
        System.out.println("Credit card number is invalid. Please try again.");


    System.out.println("main() : Exit Point");


   }

}