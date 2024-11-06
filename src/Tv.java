//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Tv extends Product {
    private int screenSize;

    public Tv(String modelName, double price, int quantity, int screenSize) {
        super(modelName, price, quantity);
        this.screenSize = screenSize;
    }

    public int getScreenSize() {
        return this.screenSize;
    }
}