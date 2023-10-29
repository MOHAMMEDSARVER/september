package day27;

import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

enum PaymentType {
    DR, CR
}

enum PaymentStatus {
    SUCCESS, FAILED
}

enum PaymentMode {
    UPI, NETBANKING, DEBITCARD, CREDITCARD
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class PaymentDetails {
    private String txnId;
    private double amount;
    private PaymentType paymentType;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
    private String fromAccNumber;
    private String toAccNumber;
}

public class AssignmentQuestion {

    public static void main(String[] args) {

        List<PaymentDetails> paymentDetails = new AssignmentQuestion().getPaymentDetails();

        // Get all Failed transactions
        List<PaymentDetails> faildPayments = paymentDetails.stream()
                .filter(e -> e.getPaymentStatus().equals(PaymentStatus.FAILED))
                .toList();
        faildPayments.forEach(System.out::println);
        System.out.println("__________________________________________________________________");

        // Get all transactions which are made by UPI
        List<PaymentDetails> upiTransactions = paymentDetails.stream()
                .filter(e -> e.getPaymentMode().equals(PaymentMode.UPI))
                .toList();
        upiTransactions.forEach(System.out::println);


        // Get failed transactions which are made by UPI and amount <= 2000
        List<PaymentDetails> faildUpi200 = paymentDetails.stream()
                .filter(e -> e.getPaymentStatus().equals(PaymentStatus.FAILED)
                        && e.getPaymentMode().equals(PaymentMode.UPI)
                        && e.getAmount() <= 2000)
                .toList();
        System.out.println("--------------------payments made by UPI and Failed and lessor than 2000_______________");
        faildUpi200.forEach(System.out::println);


        // Get all account numbers which are involved in transactions
        Set<String> accNumber = paymentDetails.stream()
                .map(e -> e.getFromAccNumber())
                .collect(Collectors.toSet());
        accNumber.addAll(paymentDetails.stream()
                .map(e -> e.getToAccNumber())
                .collect(Collectors.toSet()));
        System.out.println("_____________account numebr involved in transactions_________");
        accNumber.forEach(System.out::println);
    }

    private List<PaymentDetails> getPaymentDetails() {
        return List.of(
                new PaymentDetails("TXN1001", 5000, PaymentType.DR, PaymentStatus.SUCCESS, PaymentMode.UPI, "SB1001", "SB1002"),
                new PaymentDetails("TXN1002", 5000, PaymentType.DR, PaymentStatus.SUCCESS, PaymentMode.NETBANKING, "SB1002", "SB1003"),
                new PaymentDetails("TXN1003", 5000, PaymentType.DR, PaymentStatus.SUCCESS, PaymentMode.DEBITCARD, "SB1003", "SB1004"),
                new PaymentDetails("TXN1004", 5000, PaymentType.CR, PaymentStatus.FAILED, PaymentMode.CREDITCARD, "SB1004", "SB1005"),
                new PaymentDetails("TXN1005", 5000, PaymentType.DR, PaymentStatus.SUCCESS, PaymentMode.UPI, "SB1005", "SB1006"),
                new PaymentDetails("TXN1006", 5000, PaymentType.DR, PaymentStatus.SUCCESS, PaymentMode.NETBANKING, "SB1006", "SB1007"),
                new PaymentDetails("TXN1007", 1000, PaymentType.CR, PaymentStatus.SUCCESS, PaymentMode.DEBITCARD, "SB1007", "SB1008"),
                new PaymentDetails("TXN1008", 5000, PaymentType.DR, PaymentStatus.SUCCESS, PaymentMode.CREDITCARD, "SB1008", "SB1009"),
                new PaymentDetails("TXN1009", 1000, PaymentType.DR, PaymentStatus.SUCCESS, PaymentMode.UPI, "SB1009", "SB1010"),
                new PaymentDetails("TXN1010", 5000, PaymentType.DR, PaymentStatus.SUCCESS, PaymentMode.NETBANKING, "SB1010", "SB1011"),
                new PaymentDetails("TXN1011", 5000, PaymentType.DR, PaymentStatus.SUCCESS, PaymentMode.DEBITCARD, "SB1011", "SB1012"),
                new PaymentDetails("TXN1012", 5000, PaymentType.DR, PaymentStatus.SUCCESS, PaymentMode.CREDITCARD, "SB1012", "SB1013"),
                new PaymentDetails("TXN1013", 1000, PaymentType.DR, PaymentStatus.FAILED, PaymentMode.UPI, "SB1013", "SB1014")
        );
    }
}
