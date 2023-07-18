import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Загадайте число от 1 до 99 и нажмите любую клавишу");
        new Scanner(System.in).nextLine();
        int count = 1;
        int leftBoard = 0;
        int rightBoard = 100;
        int res = rightBoard / 2;
        while (true) {
            System.out.println("Ваше число " + res + "? д/н ");
            if ("д".equals(new Scanner(System.in).nextLine().toLowerCase(Locale.ROOT))) {
                System.out.println("Число угадано за " + count + " попыток");
                break;
            } else {
                System.out.println("Ваше число меньше " + res + "?");
                if ("д".equals(new Scanner(System.in).nextLine().toLowerCase(Locale.ROOT))) {
                    rightBoard = res;
                } else {
                    leftBoard = res;
                }
                res = (rightBoard + leftBoard) / 2;
                count++;
                if (count == 7) {
                    System.out.println("Ваше число: " + res);
                    System.out.println("Число угадано за " + count + " попыток");
                    break;
                }
            }
        }
    }
}


