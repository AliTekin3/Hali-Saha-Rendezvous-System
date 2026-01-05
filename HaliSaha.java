public class HaliSaha {
    private int id; 
    private String isim;
    private String konum;
    private double ucret;

    public HaliSaha(int id, String isim, String konum, double ucret) {
        this.id = id;
        this.isim = isim;
        this.konum = konum;
        this.ucret = ucret;
    }

    public HaliSaha(String isim, String konum, double ucret) {
        this(0, isim, konum, ucret);
    }

    public int getId() { return id; }
    public String getIsim() { return isim; }
    public double getSaatlikUcret() { return ucret; }

    @Override
    public String toString() { return isim + " (" + ucret + " TL)"; }
}
