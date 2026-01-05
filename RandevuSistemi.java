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

    public boolean randevuOlustur(HaliSaha istenenSaha, Musteri musteri, String istenenTarih) {
        for (Rezervasyon r : rezervasyonlar) {
            if (r.getSaha().equals(istenenSaha) && r.getTarihSaat().equals(istenenTarih)) {
                return false;
            }
        }
        Rezervasyon yeniRezervasyon = new Rezervasyon(istenenSaha, musteri, istenenTarih);
        rezervasyonlar.add(yeniRezervasyon);
        return true;
    }

    public boolean randevuIptal(String sahaAdi, String tarihSaat) {
        Rezervasyon silinecek = null;
        for (Rezervasyon r : rezervasyonlar) {
            if (r.getSaha().getIsim().equals(sahaAdi) && r.getTarihSaat().equals(tarihSaat)) {
                silinecek = r;
                break;
            }
        }
        if (silinecek != null) {
            rezervasyonlar.remove(silinecek);
            return true;
        }
        return false;
    }
}
