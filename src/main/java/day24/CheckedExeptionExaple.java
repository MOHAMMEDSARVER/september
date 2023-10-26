package day24;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class CheckedExeptionExaple {
    public static void main(String[] args) {
        // readDataFromFile();
        /*while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter first number:");

            int a = sc.nextInt();
            System.out.println("Enter the second number: ");
            int b = sc.nextInt();
            System.out.println("Enter the operator: ");
            String ope = sc.next();
            try {
                int res = perform(a, b, ope);
                System.out.println("The result is " + res);
            } catch (ArithmeticException e) {
                e.printStackTrace();
            }
            System.out.println("Do you want ot continue y/n");
            String choice = sc.next();
            if (choice.equals("n")) {
                break;
            }
        }*/

        try {
            showFileContent();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void showFileContent() throws IOException {
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader(new File(CheckedExeptionExaple.class.getResource("/product.csv").getFile()));
            br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                System.out.println("------------------------");

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
         /*   System.out.println("finally block is executed");
           try {
               if(br != null){
                   br.close();
               }
               if(fr != null)
               {
                   fr.close();
               }
           }
           catch (IOException e)
           {
               e.printStackTrace();
           }*/
        }
    }


    private static void readDataFromFile() {
        try {
            List<String> list = Files.readAllLines(Path.of(new File(CheckedExeptionExaple.class.getResource("/product.csv").getFile()).getAbsolutePath()));
            //list.forEach(s-> System.out.println(s));
            //or even we can use the below code to print form the list
            list.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static int perform(int a, int b, String ope) {
        return switch (ope) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    throw new ArithmeticException("Denominator cannot be the 0");
                }
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Invalid Operator");

        };
    }
}
