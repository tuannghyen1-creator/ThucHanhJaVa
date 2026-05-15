import java.util.Scanner;

// Lớp cha trừu tượng
abstract class Hinh {
    protected String mau;

    public Hinh(String mau) {
        this.mau = mau;
    }

    public abstract double tinhDienTich();
    public abstract double tinhChuVi();

    public String layThongTin() {
        return "Màu sắc: " + mau;
    }
}

// Lớp Hình Chữ Nhật kế thừa từ Hình
class HinhChuNhat extends Hinh {
    protected double chieudai, chieurong;

    public HinhChuNhat(String mau, double chieudai, double chieurong) {
        super(mau);
        this.chieudai = chieudai;
        this.chieurong = chieurong;
    }

    @Override
    public double tinhDienTich() {
        return chieudai * chieurong;
    }

    @Override
    public double tinhChuVi() {
        return (chieudai + chieurong) * 2;
    }

    @Override
    public String layThongTin() {
        return super.layThongTin() + " | Hình Chữ Nhật (Dài: " + chieudai + ", Rộng: " + chieurong + ")";
    }
}

// Lớp Hình Tròn kế thừa từ Hình
class HinhTron extends Hinh {
    private double bankinh;

    public HinhTron(String mau, double bankinh) {
        super(mau);
        this.bankinh = bankinh;
    }

    @Override
    public double tinhDienTich() {
        return Math.PI * bankinh * bankinh;
    }

    @Override
    public double tinhChuVi() {
        return 2 * Math.PI * bankinh;
    }

    @Override
    public String layThongTin() {
        return super.layThongTin() + " | Hình Tròn (Bán kính: " + bankinh + ")";
    }
}

// Lớp Hình Vuông kế thừa từ Hình Chữ Nhật
class HinhVuong extends HinhChuNhat {
    public HinhVuong(String mau, double canh) {
        super(mau, canh, canh);
    }

    @Override
    public String layThongTin() {
        return "Màu sắc: " + mau + " | Hình Vuông (Cạnh: " + chieudai + ")";
    }
}

// Lớp chính để chạy chương trình (KiemTraHinh)
public class BaiTap3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập Hình Chữ Nhật
        System.out.println("----- NHẬP HÌNH CHỮ NHẬT -----");
        System.out.print("Nhập màu: "); String mauHCN = sc.nextLine();
        System.out.print("Nhập chiều dài: "); double dai = sc.nextDouble();
        System.out.print("Nhập chiều rộng: "); double rong = sc.nextDouble();
        Hinh hcn = new HinhChuNhat(mauHCN, dai, rong);

        // 2. Nhập Hình Tròn
        sc.nextLine(); // Xóa bộ nhớ đệm
        System.out.println("\n----- NHẬP HÌNH TRÒN -----");
        System.out.print("Nhập màu: "); String mauHT = sc.nextLine();
        System.out.print("Nhập bán kính: "); double r = sc.nextDouble();
        Hinh ht = new HinhTron(mauHT, r);

        // 3. Nhập Hình Vuông
        sc.nextLine(); 
        System.out.println("\n----- NHẬP HÌNH VUÔNG -----");
        System.out.print("Nhập màu: "); String mauHV = sc.nextLine();
        System.out.print("Nhập cạnh: "); double canh = sc.nextDouble();
        Hinh hv = new HinhVuong(mauHV, canh);

        // 4. Hiển thị thông tin và tính toán
        System.out.println("\n========== KẾT QUẢ ==========");
        Hinh[] dsHinh = {hcn, ht, hv};

        for (Hinh h : dsHinh) {
            System.out.println(h.layThongTin());
            System.out.printf("=> Diện tích: %.2f\n", h.tinhDienTich());
            System.out.printf("=> Chu vi: %.2f\n", h.tinhChuVi());
            System.out.println("-----------------------------");
        }
        
        sc.close();
    }
}