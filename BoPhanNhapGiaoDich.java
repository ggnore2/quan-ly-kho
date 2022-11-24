import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

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

    }

    // tim tra lai cac vi tri trong database
    public static ArrayList<Integer> timGiaoDichTheoTenHang(String tenHang) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        String tieuChuanHoaTenHang = tenHang.toLowerCase().trim();
        try {
            String fileContent = Files.readString(Path.of(IBoPhanVoiDatabase.giaoDichPath));
            ArrayList<String> listOfGiaoDich = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfGiaoDich.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfGiaoDich.get(i).split(",")));
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

    public static ArrayList<Integer> timGiaoDichTheoLoaiHang(String loaiHang) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        String tieuChuanHoaLoaiHang = loaiHang.toLowerCase().trim();

        try {
            String fileContent = Files.readString(Path.of(IBoPhanVoiDatabase.giaoDichPath));
            ArrayList<String> listOfGiaoDich = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfGiaoDich.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfGiaoDich.get(i).split(",")));
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

    public static ArrayList<Integer> timGiaoDichTheoSoLuong(int soLuong) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        try {
            String fileContent = Files.readString(Path.of(IBoPhanVoiDatabase.giaoDichPath));
            ArrayList<String> listOfGiaoDich = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfGiaoDich.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfGiaoDich.get(i).split(",")));
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

    public static ArrayList<Integer> timGiaoDichTheoLoaiGiaoDich(String loaiGiaoDich) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        String tieuChuanHoaLoaiGiaoDich = loaiGiaoDich.toLowerCase().trim();

        try {
            String fileContent = Files.readString(Path.of(IBoPhanVoiDatabase.giaoDichPath));
            ArrayList<String> listOfGiaoDich = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfGiaoDich.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfGiaoDich.get(i).split(",")));
                String entryLoaiGiaoDich = entry.get(3);
                if (entryLoaiGiaoDich.equals(tieuChuanHoaLoaiGiaoDich)) {
                    ketQua.add(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

    public static ArrayList<Integer> timGiaoDichTheoGiaTongThe(double giaTongThe) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        try {
            String fileContent = Files.readString(Path.of(IBoPhanVoiDatabase.giaoDichPath));
            ArrayList<String> listOfGiaoDich = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfGiaoDich.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfGiaoDich.get(i).split(",")));
                double entryGiaTongThe = Double.valueOf(entry.get(4));
                if (entryGiaTongThe == giaTongThe) {
                    ketQua.add(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

    public static ArrayList<Integer> timGiaoDichTheoThoiDiem(Date thoiDiem) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        try {
            String fileContent = Files.readString(Path.of(IBoPhanVoiDatabase.giaoDichPath));
            ArrayList<String> listOfGiaoDich = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfGiaoDich.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfGiaoDich.get(i).split(",")));
                Date entryThoiDiem = (new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy")).parse(entry.get(5));
                if (entryThoiDiem.equals(thoiDiem)) {
                    ketQua.add(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

    public static ArrayList<Integer> timGiaoDichTheoDiaDiem(String diaDiem) {
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        String tieuChuanHoaDiaDiem = diaDiem.toLowerCase().trim();
        try {
            String fileContent = Files.readString(Path.of(IBoPhanVoiDatabase.giaoDichPath));
            ArrayList<String> listOfGiaoDich = new ArrayList<String>(Arrays.asList(fileContent.split("\n")));
            for (int i = 1; i < listOfGiaoDich.size(); i++) {
                ArrayList<String> entry = new ArrayList<String>(Arrays.asList(listOfGiaoDich.get(i).split(",")));
                String entryDiaDiem = entry.get(6);
                if (entryDiaDiem.equals(tieuChuanHoaDiaDiem)) {
                    ketQua.add(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

    public static ArrayList<Integer> timGiaoDichTheoThuocTinh(ArrayList<String> tenCacThuocTinh,
            ArrayList<String> giaTriCacThuocTinh) {
        ArrayList<ArrayList<Integer>> listOfArrayList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ketQua = new ArrayList<Integer>();
        try {
            int index = 0;
            for (String tenThuocTinh : tenCacThuocTinh) {
                String tieuChuanHoaTenThuocTinh = tenThuocTinh.toLowerCase().trim();
                if (tieuChuanHoaTenThuocTinh.equals("ten hang")) {
                    String tenHang = giaTriCacThuocTinh.get(index).toLowerCase().trim();
                    listOfArrayList.add(BoPhanNhapGiaoDich.timGiaoDichTheoTenHang(tenHang));
                }
                if (tieuChuanHoaTenThuocTinh.equals("loai hang")) {
                    String loaiHang = giaTriCacThuocTinh.get(index).toLowerCase().trim();
                    listOfArrayList.add(BoPhanNhapGiaoDich.timGiaoDichTheoLoaiHang(loaiHang));

                }
                if (tieuChuanHoaTenThuocTinh.equals("so luong")) {
                    int soLuong = Integer.valueOf(giaTriCacThuocTinh.get(index));
                    listOfArrayList.add(BoPhanNhapGiaoDich.timGiaoDichTheoSoLuong(soLuong));

                }
                if (tieuChuanHoaTenThuocTinh.equals("loai giao dich")) {
                    String loaiGiaoDich = giaTriCacThuocTinh.get(index).toLowerCase().trim();
                    listOfArrayList.add(BoPhanNhapGiaoDich.timGiaoDichTheoLoaiGiaoDich(loaiGiaoDich));

                }
                if (tieuChuanHoaTenThuocTinh.equals("gia tong the")) {
                    double giaTongThe = Double.valueOf(giaTriCacThuocTinh.get(index));
                    listOfArrayList.add(BoPhanNhapGiaoDich.timGiaoDichTheoGiaTongThe(giaTongThe));

                }
                if (tieuChuanHoaTenThuocTinh.equals("thoi diem")) {
                    Date thoiDiem = (new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy"))
                            .parse(giaTriCacThuocTinh.get(index));
                    listOfArrayList.add(BoPhanNhapGiaoDich.timGiaoDichTheoThoiDiem(thoiDiem));
                }
                if (tieuChuanHoaTenThuocTinh.equals("dia diem")) {
                    String diaDiem = giaTriCacThuocTinh.get(index).toLowerCase().trim();
                    listOfArrayList.add(BoPhanNhapGiaoDich.timGiaoDichTheoDiaDiem(diaDiem));
                }
                index += 1;
            }
            if (!(listOfArrayList.size() >= 1)) {
                return ketQua;
            }
            for (int i : listOfArrayList.get(0)) {
                ketQua.add(i);
            }
            for (ArrayList<Integer> arrayList : listOfArrayList) {
                ketQua.retainAll(arrayList);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ketQua;
    }

}