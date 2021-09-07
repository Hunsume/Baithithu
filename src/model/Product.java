package model;

public class Product implements Comparable<Product> {
    private String id;
    private String name;
    private int price;
    private int amount;
    private String type;

    public Product(String id, String name, int price, int amount, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.type = type;
    }

    public Product() {
    }

    public Product(String id, String name, int price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Mã sản phẩm: '" + id + '\'' +
                ", Tên sản phẩm:  " + name + '\'' +
                ", Gía sản phẩm: " + price +
                ", Số lượng sản phẩm: " + amount +
                ", Loại sản phẩm: " + type + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product product) {
        return Integer.compare(this.price, product.getPrice());
    }
}
