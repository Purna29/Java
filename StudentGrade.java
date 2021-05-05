import java.util.Scanner;

public class StudentGrade {

    public static void main(String[] args) {

        int count = 0;
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int F = 0;

        System.out.println("Enter Numbers:");
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int s1 = sc.nextInt();
            if (s1 == -1)
                break;
            count++;

            if (s1 > 100) {
                count--;
                System.out.println("Please enter Valid Grade");
            }

            if (s1 >= 90 && s1 <= 100) {
                A++;
            }

            else if (s1 >= 80 && s1 <= 89) {
                B++;
            }

            else if (s1 >= 70 && s1 <= 79) {
                C++;
            }

            else if (s1 >= 60 && s1 <= 69) {
                D++;
            }

            else if (s1 >= 1 && s1 <= 59) {
                F++;
            }

        }
        System.out.println("Total number of grades =: " + count);
        System.out.println("Number of A's = " + A);
        System.out.println("Number of B's = " + B);
        System.out.println("Number of C's = " + C);
        System.out.println("Number of D's = " + D);
        System.out.println("Number of F's = " + F);

    }

}
