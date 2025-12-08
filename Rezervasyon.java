public class Rezervasyon {
    private HaliSaha saha;
    private Musteri musteri;
    private String saat;

    public Rezervasyon(HaliSaha saha, Musteri musteri, String saat) {
        this.saha = saha;
        this.musteri = musteri;
        this.saat = saat;
    }

    public HaliSaha getSaha() { return saha; }
    public String getSaat() { return saat; }

    public String getBilgi() {
        return musteri.getAdSoyad() + " -> " + saha.getIsim() + " [" + saat + "]";
    }
}