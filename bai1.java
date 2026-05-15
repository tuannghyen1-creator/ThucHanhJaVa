import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Tìm UCLN ---
        System.out.println("1. Tìm UCLN");
        System.out.print("Nhập a và b: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("UCLN là: " + tinhUCLN(a, b));

        // --- Kiểm tra số hoàn thiện ---
        System.out.print("\n2. Nhập n kiểm tra số hoàn thiện: ");
        int n = sc.nextInt();
        System.out.println(n + (laSoHoanThien(n) ? " là số hoàn thiện" : " không phải số hoàn thiện"));

        // --- Kiểm tra toàn chữ số chẵn ---
        System.out.print("\n3. Nhập n kiểm tra toàn chữ số chẵn: ");
        int n2 = sc.nextInt();
        System.out.println("Kết quả: " + laToanChuSoChan(n2));

        // --- Tính S(x, n) ---
        System.out.print("\n4. Tính S(x, n). Nhập x và n: ");
        double x = sc.nextDouble();
        int n3 = sc.nextInt();
        System.out.printf("S(%.1f, %d) = %.4f\n", x, n3, tinhS(x, n3));

        // --- Bài số 2: Tìm số âm trong chuỗi ---
        sc.nextLine(); // Xóa bộ nhớ đệm
        System.out.print("\n5. Nhập chuỗi chứa số âm (vd: abc-5xyz-12): ");
        String str = sc.nextLine();
        NegativeNumberInStrings(str);
    }

    public static int tinhUCLN(int a, int b) {
        while (b != 0) {
            int temp = a % b; a = b; b = temp;
        }
        return a;
    }

    public static boolean laSoHoanThien(int n) {
        int tong = 0;
        for (int i = 1; i < n; i++) if (n % i == 0) tong += i;
        return tong == n && n != 0;
    }

    public static boolean laToanChuSoChan(int n) {
        if (n == 0) return true;
        n = Math.abs(n);
        while (n > 0) {
            if ((n % 10) % 2 != 0) return false;
            n /= 10;
        }
        return true;
    }

    public static double tinhS(double x, int n) {
        double s = x;
        for (int i = 1; i <= n; i++) {
            int mau = 2 * i + 1;
            s += Math.pow(x, mau) / giaiThua(mau);
        }
        return s;
    }

    private static long giaiThua(int k) {
        long gt = 1;
        for (int i = 1; i <= k; i++) gt *= i;
        return gt;
    }

    public static void NegativeNumberInStrings(String str) {
        Pattern p = Pattern.compile("-\\d+");
        Matcher m = p.matcher(str);
        int count = 0;
        System.out.print("Các số âm tìm thấy: ");
        while (m.find()) {
            System.out.print(m.group() + " ");
            count++;
        }
        System.out.println("\nTổng cộng có " + count + " số âm.");
    }
}