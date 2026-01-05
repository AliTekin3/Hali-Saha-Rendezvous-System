import java.util.ArrayList;
import java.util.List;

//Interface'i implemente eden sınıf (Verileri şimdilik listede tutuyoruz)
public class SahteVeriTabani implements IVeriTabani {
    private List<HaliSaha> sahalar = new ArrayList<>();
    private List<Rezervasyon> rezervasyonlar = new ArrayList<>();

    public SahteVeriTabani() {
        // Hazır veriler (Constructor'da yüklenir)
        sahalar.add(new HaliSaha("Yıldız Arena", "Merkez", 1400));
        sahalar.add(new HaliSaha("Şampiyonlar Halı Saha", "Kampüs", 1250));
        sahalar.add(new HaliSaha("Olimpik Tesisler", "Sanayi", 1600));
    }

    @Override
    public void sahaEkle(HaliSaha saha) {
        sahalar.add(saha);
    }

    @Override
    public List<HaliSaha> sahalariGetir() {
        return sahalar;
    }

    @Override
    public void rezervasyonKaydet(Rezervasyon r) {
        rezervasyonlar.add(r);
    }

    @Override
    public List<Rezervasyon> rezervasyonlariGetir() {
        return rezervasyonlar;
    }
}
