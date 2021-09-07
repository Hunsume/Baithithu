package view;

import controller.ProductManagement;
import model.Product;

import java.util.Scanner;

public class ProductMenu {
    ProductManagement productManagement = new ProductManagement();
    Scanner scanner = new Scanner(System.in);

    public void run() {
        int choice;
        do {
            menu();
            System.out.println("Chọn chức năng theo số (để tiếp tục) ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    display5Product();
                    break;
                }
                case 2: {
                    addNewProduct();
                    break;
                }
                case 3: {
                    updateProduct();
                    break;
                }
                case 4: {
                    removeProduct();
                    break;
                }
                case 5: {
                    sortPrice();
                    break;
                }
                case 6: {
                    findMaximumPrice();
                    break;
                }
                case 7: {
                    readFileToProgram();
                    break;
                }
                case 8: {
                    writeFileToProgram();
                    break;
                }
            }
        } while (choice != 0);
    }

    public void sortPrice() {
        productManagement.sortPrice();
    }

    public void display5Product() {
        productManagement.displayAll();

    }

    public void addNewProduct() {
        Product product = creatProduct();
        productManagement.addNew(product);
    }

    public void updateProduct() {
        System.out.println("NHẬP MÃ SẢN PHẨM CẦN CHỈNH SỬA!!");
        String id = scanner.nextLine();
        int index = productManagement.findIndex(id);
        if (index != -1){
            Product product = creatProduct();
            scanner.nextLine();
            System.out.println("Nhập vào loại mặt hàng");
            String type = scanner.nextLine();
            product.setType(type);
            productManagement.update(id, product);
        }else {
            System.out.println("Không tìm được sản phẩm với mã sản phẩm trên");
        }
    }

    public void removeProduct() {
        System.out.println("NHẬP MÃ SẢN PHẨM MUỐN XÓA!!");
        String id = scanner.nextLine();
        int index = productManagement.findIndex(id);
        if (index!= -1){
            System.out.println("Bấm Y để xóa, Hối hận ấn gì cũng quay đầu được!!!");
            String check = scanner.nextLine();
            if (check.equals("Y")) {
                productManagement.removeById(id);
                System.out.println("Gòi xong xóa xong rồi!!");
            } else {
                if (id.equals(" ")) {
                    System.out.println("Quay lại");
                    return;
                }
            }
            System.out.println("Không tìm thấy sản phẩm và mã sản phẩm trên");
        }
    }



    public void findMaximumPrice() {
        productManagement.sortPrice();
        System.out.println("Sản phẩm có giá cao nhất");
        System.out.println(productManagement.getProducts().get(0));
    }




    private Product creatProduct() {
        System.out.println("Mã sản phẩm: ");
        String id = scanner.nextLine();
        System.out.println("Tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Gía sản phẩm: ");
        int price = scanner.nextInt();
        System.out.println("Số lượng sản phẩm");
        int amount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập loại sản phẩm");
        String type = scanner.nextLine();

        return new Product(id,name,price,amount,type);
    }

    public void readFileToProgram() {
        productManagement.readFile("product.csv");
    }

    public void writeFileToProgram() {
        productManagement.writeFile("product.csv");
    }

    public void menu() {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Tìm sản phẩm có giá đắt nhất");
        System.out.println("7. Đọc từ file");
        System.out.println("8. Ghi từ file");
        System.out.println("0.Thoát ");
    }
}
