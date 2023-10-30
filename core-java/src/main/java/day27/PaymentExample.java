package day27;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

enum PaymentMethod{
    CREDIT_CARD,UPI,AUTO_DEBIT
}
record PaymentInitiator(String accNumber,PaymentMethod paymentMethod){}
record AccountPaymentProfile(String accNumber,String name,String city){}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Payment{
   private String accNumber;
    private Double amount;

}

public class PaymentExample {
    public static void main(String[] args) {

        PaymentInitiator initiator1 = new PaymentInitiator("SB1001", PaymentMethod.AUTO_DEBIT);
        PaymentInitiator initiator2 = new PaymentInitiator("SB1002", PaymentMethod.UPI);
        PaymentInitiator initiator3 = new PaymentInitiator("SB1003", PaymentMethod.CREDIT_CARD);

        List<PaymentInitiator> initiatorList= List.of(initiator1,initiator2,initiator3);

        AccountPaymentProfile profile1 = new AccountPaymentProfile("SB1001", "Krish", "HYD");
        AccountPaymentProfile profile2 = new AccountPaymentProfile("SB1002", "Manoj", "BLR");
        AccountPaymentProfile profile3 = new AccountPaymentProfile("SB1003", "Charan", "HYD");
        AccountPaymentProfile profile4 = new AccountPaymentProfile("SB1004", "Manoj", "BLR");
        List<AccountPaymentProfile> profiles = List.of(profile1,profile2,profile3,profile4);

        Payment payment=new Payment("SB1001",5000.00);
        //here without .00 only 5000 is not accpeting why?

        PaymentInitiator paymentInitiator=initiatorList.stream()
                .filter(e-> e.accNumber().equals(payment.getAccNumber()))
                .findAny()
                .orElseThrow();

        AccountPaymentProfile accountPaymentProfile=profiles.stream()
                .filter(e-> e.accNumber().equals(payment.getAccNumber()))
                .findAny()
                .orElseThrow();

        makePayment(payment,paymentInitiator,accountPaymentProfile);

    }

    private static void makePayment(Payment payment, PaymentInitiator paymentInitiator, AccountPaymentProfile accountPaymentProfile) {
        System.out.println("Payment is initiated for:"+payment.getAccNumber());
        System.out.println("Payment is initialized by :"+paymentInitiator.paymentMethod());
        System.out.println("Payment is made by :"+accountPaymentProfile.name());
        System.out.println("Paymen is made for " +payment.getAmount());
    }
}
