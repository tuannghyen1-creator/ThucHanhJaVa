import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceTest {
    private static ArrayList<Invoice> invoiceList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.util.Scanner.create(System.in).useDelimiter("\n"));

    public static void main(String[] args) {
        // Tự động nạp sẵn dữ liệu giả (Mocked data) gồm 10 hóa đơn không trùng mã
        initMockData();

        int choice;
        do {
            System.out.println("\n========= MENU QUẢN LÝ HÓA ĐƠN =========");
            System.out.println("1. Nhập thêm hóa đơn mới");
            System.out.println("2. Xuất danh sách toàn bộ hóa đơn");
            System.out.println("3. Sắp xếp hóa đơn theo Mã mặt hàng (Tăng dần)");
            System.out.println("4. Tìm kiếm hóa đơn theo Mã mặt hàng");
            System.out.println("5. Xóa một hóa đơn theo Mã mặt hàng");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Vui lòng nhập số tương ứng với menu: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (choice) {
                case 1:
                    addNewInvoice();
                    break;
                case 2:
                    displayAllInvoices();
                    break;
                case 3:
                    bubbleSortByPartNumber();
                    System.out.println("Đã sắp xếp danh sách theo mã mặt hàng tăng dần!");
                    displayAllInvoices();
                    break;
                case 4:
                    searchInvoice();
                    break;
                case 5:
                    deleteInvoice();
                    break;
                case 0:
                    System.out.println("Đang thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        } while (choice != 0);
    }

    // Hàm tạo 10 dữ liệu giả ban đầu
    private static void initMockData() {
        invoiceList.add(new Invoice("MSI01", "Card màn hình RTX 4060", 5, 350.0));
        invoiceList.add(new Invoice("LOG05", "Chuột Logitech G Pro", 12, 120.5));
        invoiceList.add(new Invoice("ASU02", "Mainboard Asus ROG", 3, 250.0));
        invoiceList.add(new Invoice("COR09", "RAM Corsair 16GB", 20, 65.0));
        invoiceList.add(new Invoice("SAM03", "Ổ cứng SSD Samsung 1TB", 15, 95.0));
        invoiceList.add(new Invoice("RAZ07", "Bàn phím Razer BlackWidow", 8, 140.0));
        invoiceList.add(new Invoice("DEL04", "Màn hình Dell Ultrasharp", 4, 400.0));
        invoiceList.add(new Invoice("SEA08", "Ổ cứng HDD Seagate 2TB", 10, 55.0));
        invoiceList.add(new Invoice("INT06", "CPU Intel Core i7", 7, 310.0));
        invoiceList.add(new Invoice("NZX10", "Tản nhiệt nước NZXT", 6, 180.0));
    }

    // Chức năng 1: Nhập thêm hóa đơn (Kiểm tra trùng mã)
    private static void addNewInvoice() {
        System.out.print("Nhập mã mặt hàng: ");
        String partNumber = scanner.nextLine().trim();

        // Kiểm tra xem mã đã tồn tại chưa
        for (Invoice inv : invoiceList) {
            if (inv.getPartNumber().equalsIgnoreCase(partNumber)) {
                System.out.println("Lỗi: Mã mặt hàng này đã tồn tại! Không được nhập trùng.");
                return;
            }
        }

        System.out.print("Nhập mô tả mặt hàng: ");
        String description = scanner.nextLine().trim();
        
        System.out.print("Nhập số lượng mua: ");
        int quantity = scanner.nextInt();
        
        System.out.print("Nhập đơn giá: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Invoice newInv = new Invoice(partNumber, description, quantity, price);
        invoiceList.add(newInv);
        System.out.println("Thêm hóa đơn thành công!");
    }

    // Chức năng 2: Xuất danh sách hóa đơn
    private static void displayAllInvoices() {
        if (invoiceList.isEmpty()) {
            System.out.println("Danh sách hóa đơn hiện đang trống.");
            return;
        }
        System.out.println("\n--- DANH SÁCH HÓA ĐƠN ---");
        for (Invoice inv : invoiceList) {
            System.out.println(inv);
        }
    }

    // Chức năng 3: Thuật toán Sắp xếp nổi bọt (Bubble Sort) theo Mã mặt hàng tăng dần
    private static void bubbleSortByPartNumber() {
        int n = invoiceList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // So sánh chuỗi mã mặt hàng
                if (invoiceList.get(j).getPartNumber().compareToIgnoreCase(invoiceList.get(j + 1).getPartNumber()) > 0) {
                    // Hoán đổi vị trí
                    Invoice temp = invoiceList.get(j);
                    invoiceList.set(j, invoiceList.get(j + 1));
                    invoiceList.set(j + 1, temp);
                }
            }
        }
    }

    // Chức năng 4: Tìm kiếm hóa đơn bằng thuật toán tuyến tính (Linear Search)
    private static void searchInvoice() {
        System.out.print("Nhập mã mặt hàng cần tìm: ");
        String searchKey = scanner.nextLine().trim();
        boolean found = false;

        for (Invoice inv : invoiceList) {
            if (inv.getPartNumber().equalsIgnoreCase(searchKey)) {
                System.out.println("\n[Kết quả tìm thấy]:");
                System.out.println(inv);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy hóa đơn nào có mã: " + searchKey);
        }
    }

    // Chức năng 5: Xóa một hóa đơn theo mã mặt hàng
    private static void deleteInvoice() {
        System.out.print("Nhập mã mặt hàng cần xóa: ");
        String deleteKey = scanner.nextLine().trim();
        boolean removed = false;

        for (int i = 0; i < invoiceList.size(); i++) {
            if (invoiceList.get(i).getPartNumber().equalsIgnoreCase(deleteKey)) {
                invoiceList.remove(i);
                System.out.println("Đã xóa thành công hóa đơn có mã: " + deleteKey);
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Không tìm thấy hóa đơn có mã này để xóa.");
        }
    }
}