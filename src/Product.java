//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Product {
    private String modelName;
    private double price;
    private int quantity;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(String modelName, double price, int quantity) {
        this.modelName = modelName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getModelName() {
        return this.modelName;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void reduceStock(int quantity) throws OutOfStockException {
        if (quantity > this.quantity) {
            throw new OutOfStockException("Not enough stock for " + this.modelName);
        } else {
            this.quantity -= quantity;
        }
    }
}