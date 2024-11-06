//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class TwoWheeler extends Product {
    private int maxSpeed;

    public TwoWheeler(String modelName, double price, int quantity, int maxSpeed) {
        super(modelName, price, quantity);
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }
}