package wallet;

public interface WalletService {

        void createWallet(String mobile,double amount); // if mobile number already exists throw exception
        void transferAmount(String fromMobile,String toMobile,double amount); // if fromMobile or toMobile not exists throw exception and if fromMobile balance is less than amount throw exception - InsufficientFundsException
        void addAmount(String mobile,double amount); // if mobile number not exists throw exception
        Wallet getWallet(String mobile); // if mobile number not exists throw exception
        void showWallets(); // show all the wallets

}
