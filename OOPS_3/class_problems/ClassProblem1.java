import java.util.*;

abstract class Payment {
    protected double amount;
    public Payment(double amount) { this.amount = amount; }
    public abstract double calculateFinalAmount();
}

class CardPayment extends Payment {
    public CardPayment(double amount) { super(amount); }
    public double calculateFinalAmount() { return amount * 1.02; }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) { super(amount); }
    public double calculateFinalAmount() { return amount * 1.01; }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) { super(amount); }
    public double calculateFinalAmount() { return amount; }
}

public class ClassProblem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;
        for(int i=0;i<n;i++){
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            double amt = Double.parseDouble(parts[1]);
            Payment p = switch(type){
                case "CARD" -> new CardPayment(amt);
                case "WALLET" -> new WalletPayment(amt);
                case "BANKTRANSFER" -> new BankTransferPayment(amt);
                default -> null;
            };
            double finalAmt = p.calculateFinalAmount();
            System.out.printf("%s: %.2f%n", type, finalAmt);
            total += finalAmt;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
