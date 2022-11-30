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
                String contentToWrite = "ten kho,dia chi,ten hang,loai hang,so luong\n";
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
    
    public void xoaMotHangTheoTenKho(String TenKho) {

    try {
        ArrayList<String> danhSachKho = new ArrayList<String>(
                Arrays.asList(Files.readString(Path.of(this.khoPat)).split("\n")));
        int index = -1;
        for (int i = 1; i < danhSachKho.size(); i++) {
            Kho tempKho = Kho.taoKho(danhSachKho.get(i), this.attributeSeparator);
            if (tempKho.getTenKho().toLowerCase().trim().equals(TenKho.toLowerCase().trim())) {
                index = i;
                break;
            }
        }
        if (index > 0) {
            danhSachKho.remove(index);
        }
        String newDatabase = String.join("\n", danhSachKho);
        FileWriter writer = new FileWriter(new File(this.khoPath));
        writer.write(newDatabase);
        writer.close();
    } catch (Exception e) {
        System.out.printf("%s\n", e.getMessage());
    }
}
public void xoaMotHangTheoDiaDiem(String DiaDiem) {

    try {
        ArrayList<String> danhSachKho = new ArrayList<String>(
                Arrays.asList(Files.readString(Path.of(this.khoPat)).split("\n")));
        int index = -1;
        for (int i = 1; i < danhSachKho.size(); i++) {
            Kho tempKho = Kho.taoKho(danhSachKho.get(i), this.attributeSeparator);
            if (tempKho.getDiaDiem().toLowerCase().trim().equals(DiaDiem.toLowerCase().trim())) {
                index = i;
                break;
            }
        }
        if (index > 0) {
            danhSachKho.remove(index);
        }
        String newDatabase = String.join("\n", danhSachKho);
        FileWriter writer = new FileWriter(new File(this.khoPath));
        writer.write(newDatabase);
        writer.close();
    } catch (Exception e) {
        System.out.printf("%s\n", e.getMessage());
    }
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
    
    public void xoaMotHangTheoTenHang(String TenHang) {

    try {
        ArrayList<String> danhSachHang = new ArrayList<String>(
                Arrays.asList(Files.readString(Path.of(this.hangPat)).split("\n")));
        int index = -1;
        for (int i = 1; i < danhSachHang.size(); i++) {
            Hang tempHang = Hang.taoHang(danhSachHang.get(i), this.attributeSeparator);
            if (tempHang.getTenHang().toLowerCase().trim().equals(TenHang.toLowerCase().trim())) {
                index = i;
                break;
            }
        }
        if (index > 0) {
            danhSachHang.remove(index);
        }
        String newDatabase = String.join("\n", danhSachHang);
        FileWriter writer = new FileWriter(new File(this.hangPath));
        writer.write(newDatabase);
        writer.close();
    } catch (Exception e) {
        System.out.printf("%s\n", e.getMessage());
    }
}
public void xoaMotHangTheoLoaiHang(String TenLoaiHang) {

    try {
        ArrayList<String> danhSachHang = new ArrayList<String>(
                Arrays.asList(Files.readString(Path.of(this.hangPat)).split("\n")));
        int index = -1;
        for (int i = 1; i < danhSachHang.size(); i++) {
            Hang tempHang = Hang.taoHang(danhSachHang.get(i), this.attributeSeparator);
            if (tempHang.getTenLoaiHang().toLowerCase().trim().equals(TenLoaiHang.toLowerCase().trim())) {
                index = i;
                break;
            }
        }
        if (index > 0) {
            danhSachHang.remove(index);
        }
        String newDatabase = String.join("\n", danhSachHang);
        FileWriter writer = new FileWriter(new File(this.hangPath));
        writer.write(newDatabase);
        writer.close();
    } catch (Exception e) {
        System.out.printf("%s\n", e.getMessage());
    }
}
public void xoaMotHangTheoSoLuongHang(long SL) {
    try {
        ArrayList<String> danhSachHang = new ArrayList<String>(
                Arrays.asList(Files.readString(Path.of(this.hangPath)).split("\n")));
        int index = -1;
        for (int i = 1; i < danhSachHang.size(); i++) {
            Hang tempHang = Hang.taoHang(danhSachHang.get(i), this.attributeSeparator);
            if (tempHang.getSL() == SL) {
                index = i;
                break;
            }
        }
        if (index > 0) {
            danhSachHang.remove(index);
        }
        String newDatabase = String.join("\n", danhSachHang);
        FileWriter writer = new FileWriter(new File(this.hangPath));
        writer.write(newDatabase);
        writer.close();
    } catch (Exception e) {
        System.out.printf("%s\n", e.getMessage());
    }
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

    public static ArrayList<Integer> timKhoVaHangTheoDiaChi(String diaChi) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        String tieuChuanHoaDiaChi = diaChi.toLowerCase().trim();
        try {
            String fileContent = Files.readString(Path.of(IBoPhanVoiDatabase.khoVaHangPath));
            ArrayList<String> listOfKhoVaHang = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfKhoVaHang.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfKhoVaHang.get(i).split(",")));
                String entryDiaChi = entry.get(1);
                if (entryDiaChi.equals(tieuChuanHoaDiaChi)) {
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
                    String diaChi = giaTriCacThuocTinh.get(index);
                    listOfArrayList.add(BoPhanNhapXuatKho.timKhoVaHangTheoDiaChi(diaChi));
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

public void xoaMotHangTheoTenKhoinKhoVaHang(String TenKhoinKhoVaHang) {

    try {
        ArrayList<String> danhSachkhoVaHang = new ArrayList<String>(
                Arrays.asList(Files.readString(Path.of(this.khoVaHangPath)).split("\n")));
        int index = -1;
        for (int i = 1; i < danhSachkhoVaHang.size(); i++) {
            KhoVaHang tempkhoVaHang = khoVaHang.taokhoVaHang(danhSachkhoVaHang.get(i), this.attributeSeparator);
            if (tempkhoVaHang.getTenKhoinKhoVaHang().toLowerCase().trim().equals(TenKhoinKhoVaHang.toLowerCase().trim())) {
                index = i;
                break;
            }
        }
        if (index > 0) {
            danhSachkhoVaHang.remove(index);
        }
        String newDatabase = String.join("\n", danhSachkhoVaHang);
        FileWriter writer = new FileWriter(new File(this.khoVaHangPath));
        writer.write(newDatabase);
        writer.close();
    } catch (Exception e) {
        System.out.printf("%s\n", e.getMessage());
    }
}
public void xoaMotHangTheoDiaDiem(String DiaDiem) {

    try {
        ArrayList<String> danhSachkhoVaHang = new ArrayList<String>(
                Arrays.asList(Files.readString(Path.of(this.khoVaHangPath)).split("\n")));
        int index = -1;
        for (int i = 1; i < danhSachkhoVaHang.size(); i++) {
            KhoVaHang tempkhoVaHang = khoVaHang.taokhoVaHang(danhSachkhoVaHang.get(i), this.attributeSeparator);
            if (tempkhoVaHang.getDiaDiem().toLowerCase().trim().equals(DiaDiem.toLowerCase().trim())) {
                index = i;
                break;
            }
        }
        if (index > 0) {
            danhSachkhoVaHang.remove(index);
        }
        String newDatabase = String.join("\n", danhSachkhoVaHang);
        FileWriter writer = new FileWriter(new File(this.khoVaHangPath));
        writer.write(newDatabase);
        writer.close();
    } catch (Exception e) {
        System.out.printf("%s\n", e.getMessage());
    }
}

public void xoaMotHangTheoTenHang(String TenHang) {

    try {
        ArrayList<String> danhSachkhoVaHang = new ArrayList<String>(
                Arrays.asList(Files.readString(Path.of(this.khoVaHangPath)).split("\n")));
        int index = -1;
        for (int i = 1; i < danhSachkhoVaHang.size(); i++) {
            KhoVaHang tempkhoVaHang = khoVaHang.taokhoVaHang(danhSachkhoVaHang.get(i), this.attributeSeparator);
            if (tempkhoVaHang.getTenHang().toLowerCase().trim().equals(TenHang.toLowerCase().trim())) {
                index = i;
                break;
            }
        }
        if (index > 0) {
            danhSachkhoVaHang.remove(index);
        }
        String newDatabase = String.join("\n", danhSachkhoVaHang);
        FileWriter writer = new FileWriter(new File(this.khoVaHangPath));
        writer.write(newDatabase);
        writer.close();
    } catch (Exception e) {
        System.out.printf("%s\n", e.getMessage());
    }
}

public void xoaMotHangTheoLoaiHang(String LoaiHang) {

    try {
        ArrayList<String> danhSachkhoVaHang = new ArrayList<String>(
                Arrays.asList(Files.readString(Path.of(this.khoVaHangPath)).split("\n")));
        int index = -1;
        for (int i = 1; i < danhSachkhoVaHang.size(); i++) {
            KhoVaHang tempkhoVaHang = khoVaHang.taokhoVaHang(danhSachkhoVaHang.get(i), this.attributeSeparator);
            if (tempkhoVaHang.getLoaiHang().toLowerCase().trim().equals(LoaiHang.toLowerCase().trim())) {
                index = i;
                break;
            }
        }
        if (index > 0) {
            danhSachkhoVaHang.remove(index);
        }
        String newDatabase = String.join("\n", danhSachkhoVaHang);
        FileWriter writer = new FileWriter(new File(this.khoVaHangPath));
        writer.write(newDatabase);
        writer.close();
    } catch (Exception e) {
        System.out.printf("%s\n", e.getMessage());
    }
}




public void xoaMotHangTheoSoLuongkhoVaHang(long SL) {
    try {
        ArrayList<String> danhSachkhoVaHang = new ArrayList<String>(
                Arrays.asList(Files.readString(Path.of(this.khoVaHangPath)).split("\n")));
        int index = -1;
        for (int i = 1; i < danhSachkhoVaHang.size(); i++) {
            KhoVaHang tempkhoVaHang = KhoVaHang.taokhoVaHang(danhSachkhoVaHang.get(i), this.attributeSeparator);
            if (tempkhoVaHang.getSL() == SL) {
                index = i;
                break;
            }
        }
        if (index > 0) {
            danhSachkhoVaHang.remove(index);
        }
        String newDatabase = String.join("\n", danhSachkhoVaHang);
        FileWriter writer = new FileWriter(new File(this.khoVaHangPath));
        writer.write(newDatabase);
        writer.close();
    } catch (Exception e) {
        System.out.printf("%s\n", e.getMessage());
    }
}
