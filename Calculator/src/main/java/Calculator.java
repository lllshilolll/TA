import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Введите первое число: ");
        Scanner scanner1 = new Scanner(System.in);
        int a = scanner1.nextInt();
        System.out.println("Введите первое знак (+, -, /, *): ");
        Scanner scanner2 = new Scanner(System.in);
        String z = scanner2.nextLine();
        z = z.trim();
        System.out.println("Введите второе число: ");
        Scanner scanner3 = new Scanner(System.in);
        int b = scanner3.nextInt();
        
        switch (z)
        {
            case ("+"):
                System.out.println(sum(a, b));
                break;
            case ("-"):
                System.out.println(diff(a, b));
                break;
            case ("*"):
                System.out.println(add(a, b));
                break;
            case ("/"):
                System.out.println(division(a, b));
                break;
            default:
                System.out.println("Введен неправильный знак!");
        }
    }
    public static int sum(int a, int b)
    {
        return a+b;
    }
    public static int diff(int a, int b)
    {
        return a-b;
    }
    public static int add(int a, int b)
    {
        return a*b;
    }
    public static double division(int a, int b)
    {
        return (double)a/(double)b;
    }

}
