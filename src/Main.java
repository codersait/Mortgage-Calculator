import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = 0;
        float monthlyInterestRate = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }
        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterestRate = scanner.nextFloat();
            if (annualInterestRate > 0 && annualInterestRate <= 30) {
                monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }
        while (true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();
            if (years > 0 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        double mortgage = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormated);
    }
}

