package quiz;

import java.util.Scanner;

public class QuizManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String username = sc.next();

        System.out.println("Enter Quize type: ");
        System.out.println("1- java, 2-gk, 3-sport");
        int ch = sc.nextInt();
        QuizeServiceImpl quizeService = new QuizeServiceImpl();
        QuizType type = switch (ch) {
            case 1 -> QuizType.JAVA;
            case 2 -> QuizType.GK;
            case 3 -> QuizType.SPORTS;

            default -> throw new IllegalStateException("Unexpected value: " + ch);
        };
        quizeService.startQuize(username, type);
    }
}
