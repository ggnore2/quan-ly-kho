public class Hang {
    private String tenHang;
    private String loaiHang;
    private int soLuong;
    private String ghiChu;

    public Hang() {
    }

    public Hang(String tenHang, String loaiHang, int soLuong, String ghiChu) {
        this.tenHang = tenHang;
        this.loaiHang = loaiHang;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
    }

    // get
    public String getTenHang() {
        return this.tenHang;
    }

    public String getLoaiHang() {
        return this.loaiHang;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    public String getGhiChu() {
        return this.ghiChu;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public void setLoaiHang(String loaiHang) {
        this.loaiHang = loaiHang;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        String result = String.format("%s,%s,%d,%s", this.getTenHang(), this.getLoaiHang(), this.getSoLuong(),
                this.getGhiChu());
        return result;
    }
}
