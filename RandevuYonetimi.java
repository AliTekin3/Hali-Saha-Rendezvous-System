public class RandevuYonetimi {
    private IVeriTabani veriTabani;

    // Gerçek DI: Bağımlılık dışarıdan enjekte edilir
    public RandevuYonetimi(IVeriTabani veriTabani) {
        this.veriTabani = veriTabani;
    }

    public boolean randevuAl(HaliSaha saha, String adSoyad, String saat) {
        // 1. Validasyon (Null ve Boş kontrolü)
        if (adSoyad == null || adSoyad.trim().isEmpty() || saat == null || saat.trim().isEmpty()) {
            return false;
        }

        // 2. Çakışma Kontrolü
        // Stream API kullanarak daha temiz bir kontrol yapılabilir
        boolean cakismaVar = veriTabani.rezervasyonlariGetir().stream()
                .anyMatch(r -> r.getSaha().getId() == saha.getId() && r.getSaat().equals(saat));

        if (cakismaVar) {
            return false; // Saha o saatte dolu
        }

        // 3. Kayıt İşlemi
        Musteri yeniMusteri = new Musteri(adSoyad, "555-0000");
        Rezervasyon yeniRez = new Rezervasyon(saha, yeniMusteri, saat);
        veriTabani.rezervasyonKaydet(yeniRez);
        return true;
    }
}
