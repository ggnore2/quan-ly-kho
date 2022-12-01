public class KhoVaHang {
    private String tenKho;
    private String diaDiem;
    private String tenHang;
    private String loaiHang;
    private int soLuong;

    public KhoVaHang() {
    }

    public KhoVaHang(String tenKho, String diaDiem, String tenHang, String loaiHang, int soLuong) {
        this.tenKho = tenKho;
        this.diaDiem = diaDiem;
        this.tenHang = tenHang;
        this.loaiHang = loaiHang;
        this.soLuong = soLuong;
    }

    // get
    public String getTenKho() {
        return this.tenKho;
    }

    public String getDiaDiem() {
        return this.diaDiem;
    }

    public String getTenHang() {
        return this.tenHang;
    }

    public String getLoaiHang() {
        return this.loaiHang;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    // set
    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public void setTenKho(String tenKho) {
        this.tenKho = tenKho;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public void setLoaiHang(String loaiHang) {
        this.loaiHang = loaiHang;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        String result = String.format("%s,%s,%s,%s,%d", this.getTenKho(), this.getDiaDiem(), this.getTenHang(),
                this.getLoaiHang(), this.getSoLuong());
        return result;
    }
}
