import java.util.Date;

public class GiaoDich {
    private String tenHang;
    private String loaiHang;
    private int soLuong;
    private String loaiGiaoDich;
    private double giaTongThe;
    private Date thoiDiem;
    private String diaDiem;

    // constructor
    public GiaoDich() {

    }

    public GiaoDich(String tenHang, String loaiHang, int soLuong, String loaiGiaoDich, double giaTongThe,
            Date thoiDiem, String diaDiem) {
        this.tenHang = tenHang;
        this.loaiHang = loaiHang;
        this.soLuong = soLuong;
        this.loaiGiaoDich = loaiGiaoDich;
        this.giaTongThe = giaTongThe;
        this.thoiDiem = thoiDiem;
        this.diaDiem = diaDiem;
    }

    // set
    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public void setLoaiHang(String loaiHang) {
        this.loaiHang = loaiHang;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setLoaiGiaoDich(String loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public void setGiaTongThe(double giaTongThe) {
        this.giaTongThe = giaTongThe;
    }

    public void setThoiDiem(Date thoiDiem) {
        this.thoiDiem = thoiDiem;
    }

    // get
    public String getTenHang() {
        return this.tenHang;
    }

    public String getLoaiHang() {
        return this.loaiHang;
    }

    public String getDiaDiem() {
        return this.diaDiem;
    }

    public double getGiaTongThe() {
        return this.giaTongThe;
    }

    public String getLoaiGiaoDich() {
        return this.loaiGiaoDich;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    public Date getThoiDiem() {
        return this.thoiDiem;
    }

    public String toString() {
        String result = String.format("%s,%s,%d,%s,%f,%s,%s", this.getTenHang().toLowerCase().trim(),
                this.getLoaiHang().toLowerCase().trim(),
                this.getSoLuong(), this.getLoaiGiaoDich().toLowerCase().trim(), this.getGiaTongThe(),
                this.getThoiDiem().toString(),
                this.getDiaDiem().toLowerCase().trim());
        return result;
    }
}
