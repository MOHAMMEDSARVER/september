package wallet;

import java.util.Scanner;

public class WalletManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        WalletService walletService=new WalletServiceImpl(); // TODO : Create object for WalletServiceImpl

        while (true){
            System.out.println("1. Create account");
            System.out.println("2. Transfer amount");
            System.out.println("3. Add amount");
            System.out.println("4. Show wallet");
            System.out.println("5. Show all wallets");
            System.out.println("6. Exit");
            System.out.println("Enter your choice :");
            int ch = sc.nextInt();
            String mobile=null;
            double amount=0;
            switch (ch){
                case 1:
                    System.out.println("Enter the mobile number :");
                    mobile = sc.next();
                    System.out.println("Enter the amount :");
                    amount = sc.nextDouble();
                    // TODO : call createWallet method
                    walletService.createWallet(mobile,amount);
                    break;
                case 2:
                    System.out.println("Enter the from mobile number :");
                    String fromMobile = sc.next();
                    System.out.println("Enter the to mobile number :");
                    String toMobile = sc.next();
                    System.out.println("Enter the amount :");
                    double transferAmount = sc.nextDouble();
                    // TODO : call transferAmount method
                    walletService.transferAmount(fromMobile,toMobile,transferAmount);
                    break;
                case 3:
                    System.out.println("Enter the mobile number :");
                    mobile = sc.next();
                    System.out.println("Enter the amount :");
                    amount = sc.nextDouble();
                    // TODO : call addAmount method
                    walletService.addAmount(mobile,amount);
                    break;
                case 4:
                    System.out.println("Enter the mobile number :");
                    mobile = sc.next();
                    // TODO : call getWallet method
                    Wallet wallet = walletService.getWallet(mobile);
                    System.out.println(wallet);
                    break;
                case 5:
                    // TODO : call showWallets method
                    walletService.showWallets();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
