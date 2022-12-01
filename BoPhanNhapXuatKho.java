import java.nio.file.Files;
import java.nio.file.Path;
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

    // kho
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
                listOfArrayList.add(BoPhanNhapXuatKho.timKhoTheoTenKho(tenKho));
            }
            if (tieuChuanHoaTenThuocTinh.equals("dia diem")) {
                String diaDiem = giaTriCacThuocTinh.get(index);
                listOfArrayList.add(BoPhanNhapXuatKho.timKhoTheoDiaDiem(diaDiem));
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

    // hang
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
                    listOfArrayList.add(BoPhanNhapXuatKho.timHangTheoTenHang(tenHang));
                }
                if (tieuChuanHoaTenThuocTinh.equals("loai hang")) {
                    String loaiHang = giaTriCacThuocTinh.get(index);
                    listOfArrayList.add(BoPhanNhapXuatKho.timHangTheoLoaiHang(loaiHang));
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

    // kho va hang
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
                    String tenKho = giaTriCacThuocTinh.get(index);
                    listOfArrayList.add(BoPhanNhapXuatKho.timKhoVaHangTheoTenKho(tenKho));
                }
                if (tieuChuanHoaTenThuocTinh.equals("dia chi")) {
                    String diaDiem = giaTriCacThuocTinh.get(index);
                    listOfArrayList.add(BoPhanNhapXuatKho.timKhoVaHangTheoDiaDiem(diaDiem));
                }
                if (tieuChuanHoaTenThuocTinh.equals("ten hang")) {
                    String tenHang = giaTriCacThuocTinh.get(index);
                    listOfArrayList.add(BoPhanNhapXuatKho.timKhoVaHangTheoTenHang(tenHang));
                }
                if (tieuChuanHoaTenThuocTinh.equals("loai hang")) {
                    String loaiHang = giaTriCacThuocTinh.get(index);
                    listOfArrayList.add(BoPhanNhapXuatKho.timKhoVaHangTheoLoaiHang(loaiHang));
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

}
