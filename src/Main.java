//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scan;
    private static final List<Product> products;
    private static final HashMap<String, Product> map;

    public Main() {
    }

    public static Product getFastest(List<String> names) throws ProductNotFoundException {
        Product fastest = null;
        int maxSpeed = -1;
        Iterator var3 = names.iterator();

        while(var3.hasNext()) {
            String name = (String)var3.next();
            Product product = (Product)map.get(name);
            int speed;
            if (product instanceof Car) {
                speed = ((Car)product).getMaxSpeed();
                if (speed > maxSpeed) {
                    maxSpeed = speed;
                    fastest = product;
                }
            } else if (product instanceof TwoWheeler) {
                speed = ((TwoWheeler)product).getMaxSpeed();
                if (speed > maxSpeed) {
                    maxSpeed = speed;
                    fastest = product;
                }
            }
        }

        if (fastest == null) {
            throw new ProductNotFoundException("No valid products with a speed attribute to compare.");
        } else {
            return fastest;
        }
    }

    public static double calculatePrice(List<String> names, List<Integer> quantities) throws ProductNotFoundException, OutOfStockException {
        double totalPrice = 0.0;

        for(int i = 0; i < names.size(); ++i) {
            String name = (String)names.get(i);
            int quantity = (Integer)quantities.get(i);
            Product product = (Product)map.get(name);
            if (product == null) {
                throw new ProductNotFoundException("Product " + name + " not found.");
            }

            if (product.getQuantity() < quantity) {
                throw new OutOfStockException("Product " + name + " is out of stock for the requested quantity.");
            }

            totalPrice += product.getPrice() * (double)quantity;
            product.setQuantity(product.getQuantity() - quantity);
        }

        return totalPrice;
    }

    private static void storeProducts() {
        System.out.println("Enter the number of products to store:");
        int productCount = scan.nextInt();

        for(int i = 0; i < productCount; ++i) {
            System.out.println("Enter product type (car, fridge, bicycle, motorbike, tv):");
            String productType = scan.next().toLowerCase();
            Product product = null;
            switch (productType) {
                case "car":
                    product = createCar();
                    break;
                case "fridge":
                    product = createFridge();
                    break;
                case "bicycle":
                case "motorbike":
                    product = createTwoWheeler();
                    break;
                case "tv":
                    product = createTv();
                    break;
                default:
                    System.out.println("Invalid product type.");
                    continue;
            }

            map.put(product.getModelName(), product);
            products.add(product);
            System.out.println("Product stored successfully.");
        }

    }

    private static Product createCar() {
        System.out.println("Enter model name, price, quantity, max speed, and engine type:");
        String modelName = scan.next();
        double price = scan.nextDouble();
        int quantity = scan.nextInt();
        int maxSpeed = scan.nextInt();
        String engineType = scan.next();
        return new Car(modelName, price, quantity, maxSpeed, engineType);
    }

    private static Product createFridge() {
        System.out.println("Enter model name, price, quantity, and max freezing degree:");
        String modelName = scan.next();
        double price = scan.nextDouble();
        int quantity = scan.nextInt();
        int maxFreezingDegree = scan.nextInt();
        return new Fridge(modelName, price, quantity, maxFreezingDegree);
    }

    private static Product createTwoWheeler() {
        System.out.println("Enter model name, price, quantity, and max speed:");
        String modelName = scan.next();
        double price = scan.nextDouble();
        int quantity = scan.nextInt();
        int maxSpeed = scan.nextInt();
        return new TwoWheeler(modelName, price, quantity, maxSpeed);
    }

    private static Product createTv() {
        System.out.println("Enter model name, price, quantity, and screen size:");
        String modelName = scan.next();
        double price = scan.nextDouble();
        int quantity = scan.nextInt();
        int screenSize = scan.nextInt();
        return new Tv(modelName, price, quantity, screenSize);
    }

    private static void inquireProducts() {
        System.out.println("Enter inquiry type:\n1) Know the fastest\n2) Calculate price");
        int choice = scan.nextInt();
        switch (choice) {
            case 1 -> inquireFastest();
            case 2 -> inquirePrice();
            default -> System.out.println("Invalid choice.");
        }

    }

    private static void inquireFastest() {
        System.out.println("Enter the number of products to compare:");
        int count = scan.nextInt();
        List<String> names = new ArrayList();

        for(int i = 0; i < count; ++i) {
            System.out.println("Enter product name:");
            names.add(scan.next());
        }

        try {
            Product fastest = getFastest(names);
            PrintStream var10000 = System.out;
            String var10001 = fastest.getModelName();
            var10000.println("Fastest product is " + var10001 + " with price " + fastest.getPrice());
        } catch (ProductNotFoundException var5) {
            System.out.println(var5.getMessage());
        }

    }

    private static void inquirePrice() {
        System.out.println("Enter the number of products to purchase:");
        int count = scan.nextInt();
        List<String> names = new ArrayList();
        List<Integer> quantities = new ArrayList();

        for(int i = 0; i < count; ++i) {
            System.out.println("Enter product name:");
            names.add(scan.next());
            System.out.println("Enter quantity:");
            quantities.add(scan.nextInt());
        }

        try {
            double totalPrice = calculatePrice(names, quantities);
            System.out.println("Total price is: " + totalPrice);
        } catch (ProductNotFoundException | OutOfStockException var5) {
            System.out.println(((Exception)var5).getMessage());
        }

    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("Do you want to store data or inquire about data?");
            System.out.println("1) Store\n2) Inquire");
            String userType = scan.next();
            if (!userType.equals("store") && !userType.equals("inquire")) {
                System.out.println("Invalid input. Please enter 'store' or 'inquire'.");
            } else if (userType.equals("store")) {
                storeProducts();
            } else {
                inquireProducts();
            }
        }
    }

    static {
        scan = new Scanner(System.in);
        products = new ArrayList();
        map = new HashMap();
    }
}