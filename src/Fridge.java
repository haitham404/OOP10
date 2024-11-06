//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Fridge extends Product {
    private int maxfreezingDegree;

    public Fridge(String modelName, double price, int quantity, int maxfreezingDegree) {
        super(modelName, price, quantity);
        this.maxfreezingDegree = maxfreezingDegree;
    }

    public int getMaxfreezingDegree() {
        return this.maxfreezingDegree;
    }

    public void setMaxfreezingDegree(int maxfreezingDegree) {
        this.maxfreezingDegree = maxfreezingDegree;
    }
}