import java.util.ArrayList;
import java.util.List;

public class RandevuSistemi {
    private List<HaliSaha> sahalar;
    private List<Rezervasyon> rezervasyonlar;

    public RandevuSistemi() {
        this.sahalar = new ArrayList<>();
        this.rezervasyonlar = new ArrayList<>();
    }

    public void sahaEkle(HaliSaha saha) {
        sahalar.add(saha);
    }

    public List<HaliSaha> getSahalar() {
        return sahalar;
    }

    public void randevuOlustur(HaliSaha saha, Musteri musteri, String tarih) {
        Rezervasyon yeniRezervasyon = new Rezervasyon(saha, musteri, tarih);
        rezervasyonlar.add(yeniRezervasyon);
        // İstersen burada veritabanına kayıt kodu da olur.
    }
}