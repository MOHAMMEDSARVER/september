package wallet;

import java.util.ArrayList;
import java.util.List;

public class WalletServiceImpl implements WalletService {
    List<Wallet> walletList = new ArrayList<>();
    Wallet wallet;

    @Override
    public void createWallet(String mobile, double amount) {

        //Wallet wallet = getWallet(mobile);
        if (mobile.length() != 10)
            throw new IllegalArgumentException("The Given Mobile number " + mobile + " is not correct , please provide valid mobile number!");


        for (Wallet w : walletList) {
            if (w.getMobile().equals(mobile)) {
                throw new IllegalArgumentException("Account alredy exist with given nuber.");

            }
        }
        wallet = new Wallet(mobile, amount);
        walletList.add(wallet);
        System.out.println("record created.");

    }

    @Override
    public void transferAmount(String fromMobile, String toMobile, double amount) {
        Wallet fromaccount = getWallet(fromMobile);
        if ((fromaccount.getBalance() - amount) < 0)
            throw new InSufficinetFundsException("Insufficinet funds in the given Account number.");
        fromaccount.setBalance(fromaccount.getBalance() - amount);
        Wallet toAccount = getWallet(toMobile);
        System.out.println("previos balance: " + toAccount.getBalance());
        toAccount.setBalance(toAccount.getBalance() + amount);
        System.out.println("Updated Account balance: " + toAccount.getBalance());
    }

    @Override
    public void addAmount(String mobile, double amount) {
        Wallet acc = getWallet(mobile);
        acc.setBalance(acc.getBalance() + amount);
    }

    @Override
    public Wallet getWallet(String mobile) {
        if (mobile.length() != 10)
            throw new IllegalArgumentException("The Given Mobile number " + mobile + " is not correct , please provide valid mobile number!");
        for (Wallet w : walletList) {
            if (w.getMobile().equals(mobile))
                return w;
        }
        throw new IllegalArgumentException("Account doesnot exist with given number : " + mobile);
    }

    @Override
    public void showWallets() {
        for (Wallet w : walletList) {
            System.out.println(w);
        }

    }
}
