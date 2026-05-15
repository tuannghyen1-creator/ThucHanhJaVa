import java.util.Scanner;

public class KiemTraHinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập Hình Chữ Nhật
        System.out.println("--- NHẬP HÌNH CHỮ NHẬT ---");
        System.out.print("Màu sắc: "); String mauHCN = sc.nextLine();
        System.out.print("Chiều dài: "); double dai = sc.nextDouble();
        System.out.print("Chiều rộng: "); double rong = sc.nextDouble();
        Hinh hcn = new HinhChuNhat(mauHCN, dai, rong);

        // Nhập Hình Tròn
        sc.nextLine(); // Clear cache
        System.out.println("\n--- NHẬP HÌNH TRÒN ---");
        System.out.print("Màu sắc: "); String mauHT = sc.nextLine();
        System.out.print("Bán kính: "); double r = sc.nextDouble();
        Hinh ht = new HinhTron(mauHT, r);

        // Nhập Hình Vuông
        sc.nextLine(); 
        System.out.println("\n--- NHẬP HÌNH VUÔNG ---");
        System.out.print("Màu sắc: "); String mauHV = sc.nextLine();
        System.out.print("Cạnh: "); double canh = sc.nextDouble();
        Hinh hv = new HinhVuong(mauHV, canh);

        // Hiển thị kết quả
        System.out.println("\n========== KẾT QUẢ ==========");
        Hinh[] ds = {hcn, ht, hv};
        for (Hinh h : ds) {
            System.out.println(h.LayThongTin());
            System.out.printf("Dien tich: %.2f | Chu vi: %.2f\n", h.TinhDienTich(), h.TinhChuVi());
            System.out.println("-----------------------------");
        }
    }
}