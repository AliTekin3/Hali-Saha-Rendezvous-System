public class RandevuYonetimi {
    // İş mantığı katmanı, Veri katmanıyla haberleşir (Dependency Injection mantığı)
    private IVeriTabani veriTabani;

    public RandevuYonetimi() {
        this.veriTabani = new SahteVeriTabani(); // Veritabanını başlattık
    }

    public java.util.List<HaliSaha> getSahalar() {
        return veriTabani.sahalariGetir();
    }

    // Çakışma Kontrolü ve Kayıt
    public boolean randevuAl(HaliSaha saha, String adSoyad, String saat) {
        // 1. Validasyon (Boş veri var mı?)
        if(adSoyad.isEmpty() || saat.isEmpty()) return false;

        // 2. Çakışma Kontrolü (Business Logic)
        for(Rezervasyon r : veriTabani.rezervasyonlariGetir()) {
            if(r.getSaha().equals(saha) && r.getSaat().equals(saat)) {
                return false; // Hata: Dolu
            }
        }

        // 3. Kayıt
        Musteri yeniMusteri = new Musteri(adSoyad, "555-0000");
        Rezervasyon yeniRez = new Rezervasyon(saha, yeniMusteri, saat);
        veriTabani.rezervasyonKaydet(yeniRez);
        return true;
    }
}