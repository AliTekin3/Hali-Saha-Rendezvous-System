// Abstract: Bu sınıftan tek başına nesne üretilemez, miras alınması gerekir.
public abstract class Kullanici {
    protected int id;
    protected String adSoyad;
    protected String telefon;

    public Kullanici(int id, String adSoyad, String telefon) {
        this.id = id;
        this.adSoyad = adSoyad;
        this.telefon = telefon;
    }

    public String getAdSoyad() {
        return adSoyad;
    }
}