public class RandevuYonetimi {
    private IVeriTabani veriTabani;

    public RandevuYonetimi(IVeriTabani veriTabani) {
        this.veriTabani = veriTabani;
    }

    public boolean randevuAl(HaliSaha saha, String adSoyad, String saat) {
        if (adSoyad == null || adSoyad.trim().isEmpty() || saat == null || saat.trim().isEmpty()) {
            return false;
        }

        boolean cakismaVar = veriTabani.rezervasyonlariGetir().stream()
                .anyMatch(r -> r.getSaha().getId() == saha.getId() && r.getSaat().equals(saat));

        if (cakismaVar) {
            return false;
        }

        Musteri yeniMusteri = new Musteri(0, adSoyad, "555-0000");
        Rezervasyon yeniRez = new Rezervasyon(saha, yeniMusteri, saat);
        veriTabani.rezervasyonKaydet(yeniRez);
        return true;
    }
}
