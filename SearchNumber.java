
import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchNumber {

    public static void guessNumber(int low, int high) throws InputMismatchException {

        int next = low + 1;
        if (low == high) {
            System.out.println("Your Guess Number is : " + next);
            return;
        }
        if (low < high) {
            int midNum = low + (int) Math.ceil(((high - low) * 1.0) / 2);

            System.out.println("Is the Guess Number Larger than " + " " + midNum + " " + ". Answer YES/NO");
            Scanner input = new Scanner(System.in);
            String string = input.nextLine();

            if (string.equals("YES") || string.equals("yes")) {
                guessNumber(midNum, high);
                return;
            } else if (string.equals("NO") || string.equals("no")) {
                guessNumber(low, midNum - 1);
                return;
            } else if (string.equals("equal")) {
                System.out.println("Your number is:" + " " + midNum);
            } else {
                throw new InputMismatchException(
                        "Please Give Valid Inputs yes/no: The Given Input" + string + " is Invalid");
            }
        }

    }

    public static void main(String[] args) {

        System.out.println("Let's play the Game!!");
        System.out.println("Guess a number in Range 1 - 1,000,000");
        Scanner input = new Scanner(System.in);
        String string = input.nextLine();
        if (string.equals("YES") || string.equals("yes")) {
            guessNumber(1, 999998);
            return;
        } else if (string.equals("NO") || string.equals("no")) {
            System.out.println("Ooops!! Please Guess the Number in Range 1 - 1,000,000");
        } else {
            throw new InputMismatchException(
                    "Please Give Valid Inputs yes/no: The Given Input " + string + " is Invalid");
        }
    }
}
