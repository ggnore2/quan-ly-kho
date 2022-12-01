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
                    String tenHang = giaTriCacThuocTinh.get(index);
                    listOfArrayList.add(BoPhanNhapGiaoDich.timGiaoDichTheoTenHang(tenHang.toLowerCase().trim()));
                }
                if (tieuChuanHoaTenThuocTinh.equals("loai hang")) {
                    String loaiHang = giaTriCacThuocTinh.get(index);
                    listOfArrayList.add(BoPhanNhapGiaoDich.timGiaoDichTheoLoaiHang(loaiHang.toLowerCase().trim()));

                }
                if (tieuChuanHoaTenThuocTinh.equals("so luong")) {
                    int soLuong = Integer.valueOf(giaTriCacThuocTinh.get(index));
                    listOfArrayList.add(BoPhanNhapGiaoDich.timGiaoDichTheoSoLuong(soLuong));

                }
                if (tieuChuanHoaTenThuocTinh.equals("loai giao dich")) {
                    String loaiGiaoDich = giaTriCacThuocTinh.get(index);
                    listOfArrayList.add(BoPhanNhapGiaoDich.timGiaoDichTheoLoaiGiaoDich(loaiGiaoDich.toLowerCase()
                            .trim()));

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
                    String diaDiem = giaTriCacThuocTinh.get(index);
                    listOfArrayList.add(BoPhanNhapGiaoDich.timGiaoDichTheoDiaDiem(diaDiem.toLowerCase().trim()));
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
    //xoa
    public static void xoaGiaoDichTheoTenHang(String TenHang) {

        try {
            File file = new File(IBoPhanVoiDatabase.giaoDichPath);
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
    public static void xoaGiaoDichTheoLoaiHang(String LoaiHang) {

        try {
            File file = new File(IBoPhanVoiDatabase.giaoDichPath);
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
    public static void xoaGiaoDichTheoSoLuong(int soLuong) {

        try {
            File file = new File(IBoPhanVoiDatabase.giaoDichPath);
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
                int  ten = Integer.valueOf(tach.get(2));
                if (ten == soLuong) {
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
    public static void xoaGiaoDichTheoLoaiGiaoDich(String LoaiGiaoDich) {

        try {
            File file = new File(IBoPhanVoiDatabase.giaoDichPath);
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
                if (ten.equals(LoaiGiaoDich)) {
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
    public static void xoaGiaoDichTheoGiaoTongThe(int giaTongThe) {

        try {
            File file = new File(IBoPhanVoiDatabase.giaoDichPath);
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
                int  ten = Integer.valueOf(tach.get(4));
                if (ten == giaTongThe) {
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
    public static void xoaGiaoDichTheoThoiDiem(Date thoiDiem) {

        try {
            File file = new File(IBoPhanVoiDatabase.giaoDichPath);
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
                Date ten = (new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy")).parse(tach.get(5));
                if (ten.equals(thoiDiem)) {
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
    public static void xoaGiaoDichTheoDiaDiem(String DiaDiem) {

        try {
            File file = new File(IBoPhanVoiDatabase.giaoDichPath);
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
                String ten = tach.get(6);
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
    public static void xoaGiaoDichTheoThuocTinh(ArrayList<String> tenCacThuocTinh,
             ArrayList<String> giaTriCacThuocTinh) {
        try {
            int index = 0;
            for (String tenThuocTinh : tenCacThuocTinh) {
                String tieuChuanHoaTenThuocTinh = tenThuocTinh.toLowerCase().trim();
                if (tieuChuanHoaTenThuocTinh.equals("ten hang")) {
                    String tenhang = giaTriCacThuocTinh.get(index);
                   xoaGiaoDichTheoTenHang(tenhang); 
                }
                if (tieuChuanHoaTenThuocTinh.equals("loai hang")) {
                    String loaiHang = giaTriCacThuocTinh.get(index);
                    xoaGiaoDichTheoLoaiHang(loaiHang);
                }
                if (tieuChuanHoaTenThuocTinh.equals("so luong")) {
                    int  soLuong = Integer.valueOf(giaTriCacThuocTinh.get(index));
                    xoaGiaoDichTheoSoLuong(soLuong);
                }
                if (tieuChuanHoaTenThuocTinh.equals("loai giao dich")) {
                    String loaiGiaoDich = giaTriCacThuocTinh.get(index);
                    xoaGiaoDichTheoLoaiGiaoDich(loaiGiaoDich);
                }
                if (tieuChuanHoaTenThuocTinh.equals("gia tong the")) {
                    int giaTongThe = Integer.valueOf(giaTriCacThuocTinh.get(index));
                    xoaGiaoDichTheoGiaoTongThe(giaTongThe);
                }
                if(tieuChuanHoaTenThuocTinh.equals("thoi diem")){
                    Date thoiDiem = (new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy"))
                    .parse(giaTriCacThuocTinh.get(index));
                    xoaGiaoDichTheoDiaDiem(tieuChuanHoaTenThuocTinh);
                }
                if(tieuChuanHoaTenThuocTinh.equals("dia diem")){
                    String DiaDiem = giaTriCacThuocTinh.get(index);
                    xoaGiaoDichTheoDiaDiem(DiaDiem);
                }
                index += 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
