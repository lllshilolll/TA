package Aviary;

public enum SizeAviary {
    SMALL(1, 3), NORMAL(2, 5), BIG(3, 6), VERY_BIG(4, 7);

    private int size;
    private int maxAnimalCount;

    SizeAviary(int size, int count) {
        this.maxAnimalCount = count;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int getMaxAnimalCount() {
        return maxAnimalCount;
    }
}
