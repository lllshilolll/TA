package stepDef;

public enum Categories {
    планшеты("Планшеты и электронные книги", 96),
    ноутбуки("Ноутбуки", 98),
    оргтехника("Оргтехника и расходники", 99);

    private String value;
    private int id;

    Categories(String value, int id) {
        this.value = value;
        this.id = id;
    }

    public int getId() {
        return id;
    }

}