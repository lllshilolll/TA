import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Введите первое число: ");
        Scanner scanner1 = new Scanner(System.in);
        int a = scanner1.nextInt();
        System.out.println("Введите первое знак (+, -, /, *): ");
        Scanner scanner2 = new Scanner(System.in);
        Character z = scanner2.next().charAt(0);
        System.out.println("Введите второе число: ");
        Scanner scanner3 = new Scanner(System.in);
        int b = scanner3.nextInt();
        int result = calculator(a, z, b);
        System.out.println("Результат: " + result);
    }

    public static int calculator(int a, char z, int b) {
        int result = 0;
        switch (z) {
            case ('+'):
                result = a + b;
                break;
            case ('-'):
                result = a - b;
                break;
            case ('*'):
                result = a * b;
                break;
            case ('/'):
                if (b == 0) {
                    System.out.println("На ноль делить нельзя!");
                    break;
                }
                result = a / b;
                break;
            default:
                System.out.println("Неправильный ввод!");
        }
        return result;
    }
}
