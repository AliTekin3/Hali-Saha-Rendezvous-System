import java.util.List;

// Sözleşme sınıfımız. Veritabanı olacak sınıfın hangi metodlara sahip olması gerektiğini söyler.
public interface IVeriTabani {
    void sahaEkle(HaliSaha saha);
    List<HaliSaha> sahalariGetir();
    void rezervasyonKaydet(Rezervasyon r);
    List<Rezervasyon> rezervasyonlariGetir();
}