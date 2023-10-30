package quiz2;

import quiz.Quistions;
import quiz.QuizType;
import quiz.QuizeService;

import java.util.Scanner;

public class QuizManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        QuizeService quizeService = new QuizServiceImpl();
        String name = sc.next();

        System.out.println("Please Enter your choice: ");
        System.out.println("1 for java Quiz:");
        System.out.println("2 for GK Quiz:");
        System.out.println("3 for SPORTS Quiz:");
        int choice = sc.nextInt();
        QuizType type = switch (choice) {
            case 1 -> QuizType.JAVA;
            case 2 -> QuizType.GK;
            case 3 -> QuizType.SPORTS;
            default -> throw new IllegalArgumentException("Provide valid choice");
        };
        quizeService.startQuize(name, type);
    }
}
