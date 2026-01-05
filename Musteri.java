// Kullanici sınıfından miras alarak (extends) kod tekrarını önlüyoruz.
public class Musteri extends Kullanici {

    // 1. Constructor: ID, AdSoyad ve Telefon alan (Uygulama.java'daki kullanım için)
    public Musteri(int id, String adSoyad, String telefon) {
        super(id, adSoyad, telefon);
    }

    // 2. Constructor: Sadece AdSoyad ve Telefon alan (RandevuYonetimi.java'daki kullanım için)
    public Musteri(String adSoyad, String telefon) {
        super(0, adSoyad, telefon);
    }

}
