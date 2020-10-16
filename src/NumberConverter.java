import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sourceRadix = 0;
        String sourceNumber = "";
        int targetRadix = 0;

        System.out.println("Type your source radix: ");
        try {
            sourceRadix = scanner.nextInt();
            if (sourceRadix < 1 || sourceRadix > 36) {
                System.out.println("error");
                System.exit(1);
            }
        } catch (InputMismatchException e) {
            System.out.println("error");
            System.exit(1);
        }

        System.out.println("Type your source number: ");
        try {
            sourceNumber = scanner.next();
        } catch (Exception e) {
            System.out.println("error");
        }

        System.out.println("Type your target radix: ");
        try {
            targetRadix = scanner.nextInt();
            if (targetRadix < 1 || targetRadix > 36) {
                System.out.println("error");
                System.exit(1);
            }
        } catch (Exception e) {
            System.out.println("error");
            System.exit(1);
        }

        NumeralSystemConverter converter = new NumeralSystemConverter();
        try {
            String targetNumber = converter.convert(sourceRadix, sourceNumber, targetRadix);
            System.out.println(targetNumber);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
