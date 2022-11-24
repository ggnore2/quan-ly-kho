import java.nio.file.Files;
import java.nio.file.Path;

public class BoPhanNhapGiaoDich implements IBoPhanVoiDatabase {
    public static void taoDatabases() {
        if (!Files.exists(Path.of(IBoPhanVoiDatabase.giaoDichPath))) {
            try {
                String contentToWrite = "ten hang,loai hang,so luong,loai giao dich,gia tong the,thoi diem,dia diem\n";
                Files.writeString(Path.of(IBoPhanVoiDatabase.giaoDichPath), contentToWrite);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // timGiaoDichTheoTen(){}
    }
}