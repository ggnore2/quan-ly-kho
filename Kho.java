public class Kho {
    private String tenKho;
    private String diaDiem;
    private int soLuongTongQuat;
    private int gioiHan;

    public Kho() {

    }

    public Kho(String tenKho, String diaDiem, int soLuongTongQuat, int gioiHan) {
        this.tenKho = tenKho;
        this.diaDiem = diaDiem;
        this.soLuongTongQuat = soLuongTongQuat;
        this.gioiHan = gioiHan;
    }

    // get
    public String getTenKho() {
        return this.tenKho;
    }

    public String getDiaDiem() {
        return this.diaDiem;
    }

    public int getSoLuongTongQuat() {
        return this.soLuongTongQuat;
    }

    public int getGioiHan() {
        return this.gioiHan;
    }

    // set

    public void setTenKho(String tenKho) {
        this.tenKho = tenKho;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public void setSoLuongTongQuat(int soLuongTongQuat) {
        this.soLuongTongQuat = soLuongTongQuat;
    }

    public void setGioiHan(int gioiHan) {
        this.gioiHan = gioiHan;
    }

    @Override
    public String toString() {
        String result = String.format("%s,%s,%d,%d", this.getTenKho(), this.getDiaDiem(), this.getSoLuongTongQuat(),
                this.getGioiHan());
        return result;
    }
}
