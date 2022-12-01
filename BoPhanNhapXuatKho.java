import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;

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
                String contentToWrite = "ten kho,dia diem,ten hang,loai hang,so luong\n";
                Files.writeString(Path.of(IBoPhanVoiDatabase.khoVaHangPath), contentToWrite);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // tim kho
    public static ArrayList<Integer> timKhoTheoTenKho(String tenKho) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        String tieuChuanHoaTenKho = tenKho.toLowerCase().trim();
        try {
            String fileContent = Files.readString(Path.of(BoPhanNhapXuatKho.khoPath));
            ArrayList<String> listOfKho = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfKho.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfKho.get(i).split(",")));
                String entryTenKho = entry.get(0);
                if (entryTenKho.equals(tieuChuanHoaTenKho)) {
                    ketQua.add(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

    public static ArrayList<Integer> timKhoTheoDiaDiem(String diaDiem) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        String tieuChuanHoaDiaDiem = diaDiem.toLowerCase().trim();
        try {
            String fileContent = Files.readString(Path.of(BoPhanNhapXuatKho.khoPath));
            ArrayList<String> listOfKho = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfKho.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfKho.get(i).split(",")));
                String entryDiaDiem = entry.get(1);
                if (entryDiaDiem.equals(tieuChuanHoaDiaDiem)) {
                    ketQua.add(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

    public static ArrayList<Integer> timKhoTheoSoLuongTongQuat(int soLuongTongQuat) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        try {
            String fileContent = Files.readString(Path.of(BoPhanNhapXuatKho.khoPath));
            ArrayList<String> listOfKho = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfKho.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfKho.get(i).split(",")));
                int entrySoLuongTongQuat = Integer.valueOf(entry.get(2));
                if (entrySoLuongTongQuat == soLuongTongQuat) {
                    ketQua.add(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

    public static ArrayList<Integer> timKhoTheoGioiHan(int gioiHan) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        try {
            String fileContent = Files.readString(Path.of(BoPhanNhapXuatKho.khoPath));
            ArrayList<String> listOfKho = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfKho.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfKho.get(i).split(",")));
                int entryGioiHan = Integer.valueOf(entry.get(3));
                if (entryGioiHan == gioiHan) {
                    ketQua.add(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

    public static ArrayList<Integer> timKhoTheoThuocTinh(ArrayList<String> tenCacThuocTinh,
            ArrayList<String> giaTriCacThuocTinh) {
        ArrayList<ArrayList<Integer>> listOfArrayList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        int index = 0;
        for (String tenThuocTinh : tenCacThuocTinh) {
            String tieuChuanHoaTenThuocTinh = tenThuocTinh.toLowerCase().trim();
            if (tieuChuanHoaTenThuocTinh.equals("ten kho")) {
                String tenKho = giaTriCacThuocTinh.get(index);
                listOfArrayList.add(BoPhanNhapXuatKho.timKhoTheoTenKho(tenKho.toLowerCase().trim()));
            }
            if (tieuChuanHoaTenThuocTinh.equals("dia diem")) {
                String diaDiem = giaTriCacThuocTinh.get(index);
                listOfArrayList.add(BoPhanNhapXuatKho.timKhoTheoDiaDiem(diaDiem.toLowerCase().trim()));
            }
            if (tieuChuanHoaTenThuocTinh.equals("so luong tong quat")) {
                int soLuongTongQuat = Integer.valueOf(giaTriCacThuocTinh.get(index));
                listOfArrayList.add(BoPhanNhapXuatKho.timKhoTheoSoLuongTongQuat(soLuongTongQuat));
            }
            if (tieuChuanHoaTenThuocTinh.equals("gioi han")) {
                int gioiHan = Integer.valueOf(giaTriCacThuocTinh.get(index));
                listOfArrayList.add(BoPhanNhapXuatKho.timKhoTheoGioiHan(gioiHan));
            }
            index += 1;
        }
        if (!(listOfArrayList.size() >= 1)) {
            return ketQua;
        }
        for (int i : listOfArrayList.get(0)) {
            ketQua.add(i);
        }
        for (ArrayList<Integer> entry : listOfArrayList) {
            ketQua.retainAll(entry);
        }
        return ketQua;
    }
    //xoa kho
    public static void xoaKhoTheoTenKho(String  TenKho) {
      
        try {
            File file = new File(BoPhanNhapXuatKho.khoPath);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
 
            String line = "";
            ArrayList<String> temp = new ArrayList<String>();
            while((line = reader.readLine()) != null){
                temp.add(line);
            }
            for (int i = 1; i < temp.size(); i++) {
                ArrayList<String> tach = new ArrayList<String>(Arrays.asList(temp.get(i).split(", ")));
                String ten = tach.get(0);
                if (ten.equals(TenKho)) {
                    temp.remove(i);
                }
            }
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
 
            for (String item : temp){
                outputStreamWriter.write(item);
             
                outputStreamWriter.write("\n");
            }
            outputStreamWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static void xoaKhoTheoDiaDiem (String DiaDiem) {

        try {
            File file = new File(BoPhanNhapXuatKho.khoPath);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
 
            String line = "";
            ArrayList<String> temp = new ArrayList<String>();
            while((line = reader.readLine()) != null){
                temp.add(line);
            }
            for (int i = 1; i < temp.size(); i++) {
                ArrayList<String> tach = new ArrayList<String>(Arrays.asList(temp.get(i).split(", ")));
                String ten = tach.get(1);
                if (ten.equals(DiaDiem)) {
                    temp.remove(i);
                }
            }
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
 
            for (String item : temp){
                outputStreamWriter.write(item);
             
                outputStreamWriter.write("\n");
            }
            outputStreamWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    public static void xoaKhoTheoSoLuongTongQuat (int SL) {

        try {
            File file = new File(BoPhanNhapXuatKho.khoPath);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
 
            String line = "";
            ArrayList<String> temp = new ArrayList<String>();
            while((line = reader.readLine()) != null){
                temp.add(line);
            }
            for (int i = 1; i < temp.size(); i++) {
                ArrayList<String> tach = new ArrayList<String>(Arrays.asList(temp.get(i).split(", ")));
                int ten = Integer.valueOf(tach.get(2));
                if (ten == SL) {
                    temp.remove(i);
                }
            }
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
 
            for (String item : temp){
                outputStreamWriter.write(item);
                outputStreamWriter.write("\n");
            }
            outputStreamWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    public static void xoaKhoTheoGioiHan (int GioiHan) {

        try {
            File file = new File(BoPhanNhapXuatKho.khoPath);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
 
            String line = "";
            ArrayList<String> temp = new ArrayList<String>();
            while((line = reader.readLine()) != null){
                temp.add(line);
            }
            for (int i = 1; i < temp.size(); i++) {
                ArrayList<String> tach = new ArrayList<String>(Arrays.asList(temp.get(i).split(", ")));
                int ten = Integer.valueOf(tach.get(3));
                if (ten == GioiHan) {
                    temp.remove(i);
                }
            }
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
 
            for (String item : temp){
                outputStreamWriter.write(item);
                outputStreamWriter.write("\n");
            }
            outputStreamWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    public static void xoaKhoTheoThuocTinh(ArrayList<String> tenCacThuocTinh,
    ArrayList<String> giaTriCacThuocTinh) {
        try {
        int index = 0;
        for (String tenThuocTinh : tenCacThuocTinh) {
            String tieuChuanHoaTenThuocTinh = tenThuocTinh.toLowerCase().trim();
            if (tieuChuanHoaTenThuocTinh.equals("ten kho")) {
                String tenkho = giaTriCacThuocTinh.get(index);
                xoaKhoTheoTenKho(tenkho);
            }
            if (tieuChuanHoaTenThuocTinh.equals("dia diem")) {
                String DiaDiem = giaTriCacThuocTinh.get(index);
                xoaKhoTheoDiaDiem(DiaDiem);
            }
            if (tieuChuanHoaTenThuocTinh.equals("so luong tong quat")) {
                int SLTQ = Integer.valueOf(giaTriCacThuocTinh.get(index));
                    xoaKhoTheoSoLuongTongQuat(SLTQ);
            }
            if (tieuChuanHoaTenThuocTinh.equals("gioi han")) {
                int  gioiHan = Integer.valueOf(giaTriCacThuocTinh.get(index));
                xoaKhoTheoGioiHan(gioiHan);
            }
            
            index += 1;
        }
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
    }

    // tim hang
    public static ArrayList<Integer> timHangTheoTenHang(String tenHang) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        String tieuChuanHoaTenHang = tenHang.toLowerCase().trim();
        try {
            String fileContent = Files.readString(Path.of(IBoPhanVoiDatabase.hangPath));
            ArrayList<String> listOfHang = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfHang.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfHang.get(i).split(",")));
                String entryTenHang = entry.get(0);
                if (entryTenHang.equals(tieuChuanHoaTenHang)) {
                    ketQua.add(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

    public static ArrayList<Integer> timHangTheoLoaiHang(String loaiHang) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        String tieuChuanHoaLoaiHang = loaiHang.toLowerCase().trim();
        try {
            String fileContent = Files.readString(Path.of(IBoPhanVoiDatabase.hangPath));
            ArrayList<String> listOfHang = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfHang.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfHang.get(i).split(",")));
                String entryLoaiHang = entry.get(1);
                if (entryLoaiHang.equals(tieuChuanHoaLoaiHang)) {
                    ketQua.add(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

    public static ArrayList<Integer> timHangTheoSoLuong(int soLuong) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        try {
            String fileContent = Files.readString(Path.of(IBoPhanVoiDatabase.hangPath));
            ArrayList<String> listOfHang = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfHang.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfHang.get(i).split(",")));
                int entrySoLuong = Integer.valueOf(entry.get(2));
                if (entrySoLuong == soLuong) {
                    ketQua.add(i);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

    public static ArrayList<Integer> timHangTheoThuocTinh(ArrayList<String> tenCacThuocTinh,
            ArrayList<String> giaTriCacThuocTinh) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> listOfArrayList = new ArrayList<ArrayList<Integer>>();
        try {
            int index = 0;
            for (String tenThuocTinh : tenCacThuocTinh) {
                String tieuChuanHoaTenThuocTinh = tenThuocTinh.toLowerCase().trim();
                if (tieuChuanHoaTenThuocTinh.equals("ten hang")) {
                    String tenHang = giaTriCacThuocTinh.get(index);
                    listOfArrayList.add(BoPhanNhapXuatKho.timHangTheoTenHang(tenHang.toLowerCase().trim()));
                }
                if (tieuChuanHoaTenThuocTinh.equals("loai hang")) {
                    String loaiHang = giaTriCacThuocTinh.get(index);
                    listOfArrayList.add(BoPhanNhapXuatKho.timHangTheoLoaiHang(loaiHang.toLowerCase().trim()));
                }
                if (tieuChuanHoaTenThuocTinh.equals("so luong")) {
                    int soLuong = Integer.valueOf(giaTriCacThuocTinh.get(index));
                    listOfArrayList.add(BoPhanNhapXuatKho.timHangTheoSoLuong(soLuong));
                }
                index += 1;
            }
            if (!(listOfArrayList.size() >= 1)) {
                return ketQua;
            }
            for (int i : listOfArrayList.get(0)) {
                ketQua.add(i);
            }
            for (ArrayList<Integer> entry : listOfArrayList) {
                ketQua.retainAll(entry);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }
    // xoa hang
    public static void xoaHangTheoTenHang(String  TenHang) {
      
        try {
            File file = new File(IBoPhanVoiDatabase.hangPath);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
 
            String line = "";
            ArrayList<String> temp = new ArrayList<String>();
            while((line = reader.readLine()) != null){
                temp.add(line);
            }
            for (int i = 1; i < temp.size(); i++) {
                ArrayList<String> tach = new ArrayList<String>(Arrays.asList(temp.get(i).split(", ")));
                String ten = tach.get(0);
                if (ten.equals(TenHang)) {
                    temp.remove(i);
                }
            }
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
 
            for (String item : temp){
                outputStreamWriter.write(item);
             
                outputStreamWriter.write("\n");
            }
            outputStreamWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static void xoaHangTheoLoaiHang(String TenLoaiHang) {

        try {
            File file = new File(IBoPhanVoiDatabase.hangPath);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
 
            String line = "";
            ArrayList<String> temp = new ArrayList<String>();
            while((line = reader.readLine()) != null){
                temp.add(line);
            }
            for (int i = 1; i < temp.size(); i++) {
                ArrayList<String> tach = new ArrayList<String>(Arrays.asList(temp.get(i).split(", ")));
                String ten = tach.get(1);
                if (ten.equals(TenLoaiHang)) {
                    temp.remove(i);
                }
            }
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
 
            for (String item : temp){
                outputStreamWriter.write(item);
             
                outputStreamWriter.write("\n");
            }
            outputStreamWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void xoaHangTheoSoLuong(long SL) {
        try {
            File file = new File(IBoPhanVoiDatabase.hangPath);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
 
            String line = "";
            ArrayList<String> temp = new ArrayList<String>();
            while((line = reader.readLine()) != null){
                temp.add(line);
            }
            for (int i = 1; i < temp.size(); i++) {
                ArrayList<String> tach = new ArrayList<String>(Arrays.asList(temp.get(i).split(", ")));
                int ten = Integer.valueOf(tach.get(2));
                if (ten == SL) {
                    temp.remove(i);
                }
            }
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
 
            for (String item : temp){
                outputStreamWriter.write(item);
                outputStreamWriter.write("\n");
            }
            outputStreamWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void xoaHangTheoGhiChu(String GhiChu) {

        try {
            File file = new File(IBoPhanVoiDatabase.hangPath);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
 
            String line = "";
            ArrayList<String> temp = new ArrayList<String>();
            while((line = reader.readLine()) != null){
                temp.add(line);
            }
            for (int i = 1; i < temp.size(); i++) {
                ArrayList<String> tach = new ArrayList<String>(Arrays.asList(temp.get(i).split(", ")));
                String ten = tach.get(3);
                if (ten.equals(GhiChu)) {
                    temp.remove(i);
                }
            }
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
 
            for (String item : temp){
                outputStreamWriter.write(item);
             
                outputStreamWriter.write("\n");
            }
            outputStreamWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void xoaHangTheoThuocTinh(ArrayList<String> tenCacThuocTinh,
    ArrayList<String> giaTriCacThuocTinh) {
        try {
        int index = 0;
        for (String tenThuocTinh : tenCacThuocTinh) {
            String tieuChuanHoaTenThuocTinh = tenThuocTinh.toLowerCase().trim();
            if (tieuChuanHoaTenThuocTinh.equals("ten hang")) {
                String tenhang = giaTriCacThuocTinh.get(index);
                xoaHangTheoTenHang(tenhang); 
            }
            if (tieuChuanHoaTenThuocTinh.equals("loai hang")) {
                String loaiHang = giaTriCacThuocTinh.get(index);
                xoaHangTheoLoaiHang(loaiHang);
            }
            if (tieuChuanHoaTenThuocTinh.equals("so luong")) {
                int SL = Integer.valueOf(giaTriCacThuocTinh.get(index));
                    xoaHangTheoSoLuong(SL);
            }
            if (tieuChuanHoaTenThuocTinh.equals("ghi chu")) {
                String ghiChu = giaTriCacThuocTinh.get(index);
                xoaHangTheoGhiChu(ghiChu);
            }
            
            index += 1;
        }
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
    }

    // tim kho va hang
    public static ArrayList<Integer> timKhoVaHangTheoTenKho(String tenKho) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        String tieuChuanHoaKho = tenKho.toLowerCase().trim();
        try {
            String fileContent = Files.readString(Path.of(IBoPhanVoiDatabase.khoVaHangPath));
            ArrayList<String> listOfKhoVaHang = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfKhoVaHang.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfKhoVaHang.get(i).split(",")));
                String entryTenKho = entry.get(0);
                if (entryTenKho.equals(tieuChuanHoaKho)) {
                    ketQua.add(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

    public static ArrayList<Integer> timKhoVaHangTheoDiaDiem(String diaDiem) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        String tieuChuanHoaDiaDiem = diaDiem.toLowerCase().trim();
        try {
            String fileContent = Files.readString(Path.of(IBoPhanVoiDatabase.khoVaHangPath));
            ArrayList<String> listOfKhoVaHang = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfKhoVaHang.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfKhoVaHang.get(i).split(",")));
                String entryDiaDiem = entry.get(1);
                if (entryDiaDiem.equals(tieuChuanHoaDiaDiem)) {
                    ketQua.add(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

    public static ArrayList<Integer> timKhoVaHangTheoTenHang(String tenHang) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        String tieuChuanHoaTenHang = tenHang.toLowerCase().trim();
        try {
            String fileContent = Files.readString(Path.of(IBoPhanVoiDatabase.khoVaHangPath));
            ArrayList<String> listOfKhoVaHang = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfKhoVaHang.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfKhoVaHang.get(i).split(",")));
                String entryTenHang = entry.get(2);
                if (entryTenHang.equals(tieuChuanHoaTenHang)) {
                    ketQua.add(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

    public static ArrayList<Integer> timKhoVaHangTheoLoaiHang(String loaiHang) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        String tieuChuanHoaLoaiHang = loaiHang.toLowerCase().trim();
        try {
            String fileContent = Files.readString(Path.of(IBoPhanVoiDatabase.khoVaHangPath));
            ArrayList<String> listOfKhoVaHang = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfKhoVaHang.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfKhoVaHang.get(i).split(",")));
                String entryLoaiHang = entry.get(3);
                if (entryLoaiHang.equals(tieuChuanHoaLoaiHang)) {
                    ketQua.add(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

    public static ArrayList<Integer> timKhoVaHangTheoSoLuong(int soLuong) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        try {
            String fileContent = Files.readString(Path.of(IBoPhanVoiDatabase.khoVaHangPath));
            ArrayList<String> listOfKhoVaHang = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfKhoVaHang.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfKhoVaHang.get(i).split(",")));
                int entrySoLuong = Integer.valueOf(entry.get(4));
                if (entrySoLuong == soLuong) {
                    ketQua.add(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

    public static ArrayList<Integer> timKhoVaHangTheoThuocTinh(ArrayList<String> tenCacThuocTinh,
            ArrayList<String> giaTriCacThuocTinh) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> listOfArrayList = new ArrayList<ArrayList<Integer>>();
        try {
            int index = 0;
            for (String tenThuocTinh : tenCacThuocTinh) {
                String tieuChuanHoaTenThuocTinh = tenThuocTinh.toLowerCase().trim();
                if (tieuChuanHoaTenThuocTinh.equals("ten kho")) {
                    String tenKho = giaTriCacThuocTinh.get(index).toLowerCase().trim();
                    listOfArrayList.add(BoPhanNhapXuatKho.timKhoVaHangTheoTenKho(tenKho));
                }
                if (tieuChuanHoaTenThuocTinh.equals("dia diem")) {
                    String diaDiem = giaTriCacThuocTinh.get(index);
                    listOfArrayList.add(BoPhanNhapXuatKho.timKhoVaHangTheoDiaDiem(diaDiem.toLowerCase().trim()));
                }
                if (tieuChuanHoaTenThuocTinh.equals("ten hang")) {
                    String tenHang = giaTriCacThuocTinh.get(index);
                    listOfArrayList.add(BoPhanNhapXuatKho.timKhoVaHangTheoTenHang(tenHang.toLowerCase().trim()));
                }
                if (tieuChuanHoaTenThuocTinh.equals("loai hang")) {
                    String loaiHang = giaTriCacThuocTinh.get(index);
                    listOfArrayList.add(BoPhanNhapXuatKho.timKhoVaHangTheoLoaiHang(loaiHang.toLowerCase().trim()));
                }
                if (tieuChuanHoaTenThuocTinh.equals("so luong")) {
                    int soLuong = Integer.valueOf(giaTriCacThuocTinh.get(index));
                    listOfArrayList.add(BoPhanNhapXuatKho.timKhoVaHangTheoSoLuong(soLuong));
                }
                index += 1;
            }
            if (!(listOfArrayList.size() >= 1)) {
                return ketQua;
            }
            for (int i : listOfArrayList.get(0)) {
                ketQua.add(i);
            }
            for (ArrayList<Integer> entry : listOfArrayList) {
                ketQua.retainAll(entry);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }
    // xoa kho va hang
     public static void xoakhoVaHangTheoTenKho(String TenKho) {

        try {
            File file = new File(IBoPhanVoiDatabase.khoVaHangPath);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
    
            String line = "";
            ArrayList<String> temp = new ArrayList<String>();
            while((line = reader.readLine()) != null){
                temp.add(line);
            }
            for (int i = 1; i < temp.size(); i++) {
                ArrayList<String> tach = new ArrayList<String>(Arrays.asList(temp.get(i).split(", ")));
                String ten = tach.get(0);
                if (ten.equals(TenKho)) {
                    temp.remove(i);
                }
            }
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
    
            for (String item : temp){
                outputStreamWriter.write(item);
             
                outputStreamWriter.write("\n");
            }
            outputStreamWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void xoakhoVaHangTheoDiaDiem(String DiaDiem) {
    
        try {
            File file = new File(IBoPhanVoiDatabase.khoVaHangPath);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
    
            String line = "";
            ArrayList<String> temp = new ArrayList<String>();
            while((line = reader.readLine()) != null){
                temp.add(line);
            }
            for (int i = 1; i < temp.size(); i++) {
                ArrayList<String> tach = new ArrayList<String>(Arrays.asList(temp.get(i).split(", ")));
                String ten = tach.get(1);
                if (ten.equals(DiaDiem)) {
                    temp.remove(i);
                }
            }
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
    
            for (String item : temp){
                outputStreamWriter.write(item);
             
                outputStreamWriter.write("\n");
            }
            outputStreamWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void xoaKhoVaHangTheoTenHang(String TenHang) {
    
            try {
                File file = new File(IBoPhanVoiDatabase.khoVaHangPath);
                InputStream inputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
        
                String line = "";
                ArrayList<String> temp = new ArrayList<String>();
                while((line = reader.readLine()) != null){
                    temp.add(line);
                }
                for (int i = 1; i < temp.size(); i++) {
                    ArrayList<String> tach = new ArrayList<String>(Arrays.asList(temp.get(i).split(", ")));
                    String ten = tach.get(2);
                    if (ten.equals(TenHang)) {
                        temp.remove(i);
                    }
                }
                OutputStream outputStream = new FileOutputStream(file);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        
                for (String item : temp){
                    outputStreamWriter.write(item);
                 
                    outputStreamWriter.write("\n");
                }
                outputStreamWriter.flush();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    
        public static void xoaKhoVaHangTheoLoaiHang(String LoaiHang) {
    
            try {
                File file = new File(IBoPhanVoiDatabase.khoVaHangPath);
                InputStream inputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
        
                String line = "";
                ArrayList<String> temp = new ArrayList<String>();
                while((line = reader.readLine()) != null){
                    temp.add(line);
                }
                for (int i = 1; i < temp.size(); i++) {
                    ArrayList<String> tach = new ArrayList<String>(Arrays.asList(temp.get(i).split(", ")));
                    String ten = tach.get(3);
                    if (ten.equals(LoaiHang)) {
                        temp.remove(i);
                    }
                }
                OutputStream outputStream = new FileOutputStream(file);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        
                for (String item : temp){
                    outputStreamWriter.write(item);
                 
                    outputStreamWriter.write("\n");
                }
                outputStreamWriter.flush();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    
        public static void xoaKhoVaHangTheoSoLuong(long SL) {
            try {
                File file = new File(IBoPhanVoiDatabase.khoVaHangPath);
                InputStream inputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
     
                String line = "";
                ArrayList<String> temp = new ArrayList<String>();
                while((line = reader.readLine()) != null){
                    temp.add(line);
                }
                for (int i = 1; i < temp.size(); i++) {
                    ArrayList<String> tach = new ArrayList<String>(Arrays.asList(temp.get(i).split(", ")));
                    int ten = Integer.valueOf(tach.get(4));
                    if (ten == SL) {
                        temp.remove(i);
                    }
                }
                OutputStream outputStream = new FileOutputStream(file);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
     
                for (String item : temp){
                    outputStreamWriter.write(item);
                    outputStreamWriter.write("\n");
                }
                outputStreamWriter.flush();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        public static void xoaKhoVaHangTheoThuocTinh(ArrayList<String> tenCacThuocTinh,
             ArrayList<String> giaTriCacThuocTinh) {
        try {
            int index = 0;
            for (String tenThuocTinh : tenCacThuocTinh) {
                String tieuChuanHoaTenThuocTinh = tenThuocTinh.toLowerCase().trim();
                if (tieuChuanHoaTenThuocTinh.equals("ten kho")) {
                    String tenKho = giaTriCacThuocTinh.get(index);
                    xoakhoVaHangTheoTenKho(tenKho);  
                }
                if (tieuChuanHoaTenThuocTinh.equals("dia diem")) {
                    String DiaDiem = giaTriCacThuocTinh.get(index);
                    xoakhoVaHangTheoDiaDiem(DiaDiem);
                }
                if (tieuChuanHoaTenThuocTinh.equals("ten hang")) {
                    String tenHang = giaTriCacThuocTinh.get(index);
                    xoaKhoVaHangTheoTenHang(tenHang);
                }
                if (tieuChuanHoaTenThuocTinh.equals("loai hang")) {
                    String loaiHang = giaTriCacThuocTinh.get(index);
                    xoaKhoVaHangTheoLoaiHang(loaiHang);
                }
                if (tieuChuanHoaTenThuocTinh.equals("so luong")) {
                    int soLuong = Integer.valueOf(giaTriCacThuocTinh.get(index));
                    xoaKhoVaHangTheoSoLuong(soLuong);
                }
                index += 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
