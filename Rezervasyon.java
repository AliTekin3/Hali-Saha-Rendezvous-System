public class Rezervasyon {
    private HaliSaha saha;
    private Musteri musteri;
    private String tarihSaat;

    public Rezervasyon(HaliSaha saha, Musteri musteri, String tarihSaat) {
        this.saha = saha;
        this.musteri = musteri;
        this.tarihSaat = tarihSaat;
    }

    public String getOzetBilgi() {
        return "Müşteri: " + musteri.getAdSoyad() +
                " | Saha: " + saha.getIsim() +
                " | Tarih: " + tarihSaat;
    }

    public HaliSaha getSaha() { return saha; }
    public String getTarihSaat() { return tarihSaat; }
    public String getSaat() { return tarihSaat; }
}
