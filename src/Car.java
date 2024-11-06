//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Car extends Product {
    private int maxSpeed;
    private String typeOfEngine;

    public Car(String modelName, double price, int quantity, int maxSpeed, String typeOfEngine) {
        super(modelName, price, quantity);
        this.maxSpeed = maxSpeed;
        this.typeOfEngine = typeOfEngine;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public String getTypeOfEngine() {
        return this.typeOfEngine;
    }
}