import model.Kotik;

public class Application {
    public static void main(String[] args) {
        Kotik kot1 = new Kotik(5, 4, "Vasya", "meowww");
        Kotik kot2 = new Kotik();
        kot2.setKotik(2, 5, "Persik", "meowww");
        System.out.println("Вес " + kot2.getName() + " - " + kot2.getWeight() + " кг\n");
        kot1.liveAnotherDay();
        if (kot1.getMeow().equals(kot2.getMeow())){
            System.out.println(kot1.getName() + " и " + kot2.getName() + " разговаривают одинакова: " + kot1.getMeow() + "\n");
        }
        else System.out.println("Коты разговаривают по разному");
        System.out.println("Всего создано котов: " + Kotik.getCount());
    }
}
