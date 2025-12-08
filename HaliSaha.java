public class HaliSaha {
    private String isim;
    private String konum;
    private double ucret;

    public HaliSaha(String isim, String konum, double ucret) {
        this.isim = isim;
        this.konum = konum;
        this.ucret = ucret;
    }

    public String getIsim() { return isim; }
    // toString metodunu override ettik ki arayüzde nesne adresi değil ismi görünsün
    @Override
    public String toString() { return isim + " (" + ucret + " TL)"; }
}
