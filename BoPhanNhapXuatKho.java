import java.nio.file.Files;
import java.nio.file.Path;

public class BoPhanNhapXuatKho implements IBoPhanVoiDatabase {
    public static void taoDatabases() {

        // tao hang.txt
        if (!Files.exists(Path.of(IBoPhanVoiDatabase.hangPath))) {
            try {
                String contentToWrite = "ten hang,loai hang,so luong,ghi chu\n";
                Files.writeString(Path.of(IBoPhanVoiDatabase.hangPath), contentToWrite);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // tao kho.txt
        if (!Files.exists(Path.of(IBoPhanVoiDatabase.khoPath))) {
            try {
                String contentToWrite = "ten kho,dia diem,so luong tong quat,gioi han\n";
                Files.writeString(Path.of(IBoPhanVoiDatabase.khoPath), contentToWrite);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // tao khoVaHang.txt
        if (!Files.exists(Path.of(IBoPhanVoiDatabase.khoVaHangPath))) {
            try {
                String contentToWrite = "ten kho,dia chi,ten hang,loai hang,so luong\n";
                Files.writeString(Path.of(IBoPhanVoiDatabase.khoVaHangPath), contentToWrite);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}