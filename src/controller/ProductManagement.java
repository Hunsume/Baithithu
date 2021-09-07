package controller;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProductManagement {
    private List<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void displayAll() {
        if (products.isEmpty()) {
            System.out.println("Không tồn tại sản phẩm nào!");
        }
        int count = 0;
        for (Product product : products) {
            System.out.println(product);
            count++;
            if (count == 5) {
                count = 0;
                scanner.nextLine();
            }
        }
    }

    public void addNew(Product product) {
        products.add(product);
    }

    public void update(String id, Product product) {
        int index = findIndex(id);
        products.set(index, product);
    }

    public void removeById(String id) {
        int index = findIndex(id);
        if (index != -1) {
            products.remove(index);
        } else {
            System.out.println("Không tồn tại sản phẩm này!");
        }
    }

    public void sortPrice() {
        products.sort(Product::compareTo);

    }

    //    public void sortSmallToBigPrice() {
//        Product product;
//        int position;
//        for (int i = 0; i < products.size(); i++) {
//            product = products.get(i);
//            position = i;
//            while (position > 0 && (product.getPrice() > products.get(position - 1).getPrice())) {
//                products.set(position, products.get(position - 1));
//                position--;
//            }
//            products.set(position, product);
//        }
//    }
//
//    public void sortBigToSmallPrice() {
//        Product product;
//        int position;
//        for (int i = 1; i < products.size(); i++) {
//            product = products.get(i);
//            position = i;
//            while (position > 0 && (product.getPrice() < products.get(position - 1).getPrice())) {
//                products.set(position, products.get(position - 1));
//                position--;
//            }
//            products.set(position, product);
//        }
    public List<Product> readFile(String path) {
        try {
            InputStream is = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(is);
            products = (List<Product>) ois.readObject();
            ois.close();
            is.close();
        } catch (EOFException e) {
            return null;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void writeFile(String path) {
        try {
            OutputStream os = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(products);
            oos.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int findIndex(String id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

}
