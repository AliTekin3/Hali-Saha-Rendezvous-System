import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Uygulama extends JFrame {

    // Arayüz Elemanları
    private JComboBox<HaliSaha> comboSahalar;
    private JTextField txtAdSoyad;
    private JTextField txtSaat;
    private JTextArea txtSonuc;

    // Backend Bağlantısı
    private RandevuSistemi sistem;

    public Uygulama() {
        // --- 1. SİSTEMİ HAZIRLA ---
        sistem = new RandevuSistemi();
        sistem.sahaEkle(new HaliSaha("Yıldız Arena", "Merkez", 1500.0));
        sistem.sahaEkle(new HaliSaha("Kuzey Tesisleri", "Sanayi", 1200.0));
        sistem.sahaEkle(new HaliSaha("Şampiyonlar Halı Saha", "Kampüs", 1350.0));

        // --- 2. PENCERE AYARLARI ---
        setTitle("Halı Saha Randevu Sistemi v1.0");
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15)); // Biraz boşluklu dizilim

        // --- 3. BİLEŞENLER ---

        // Saha Seçimi
        add(new JLabel("Halı Saha Seçiniz:"));
        comboSahalar = new JComboBox<>();
        // Sistemdeki sahaları kutuya dolduruyoruz
        for (HaliSaha saha : sistem.getSahalar()) {
            comboSahalar.addItem(saha);
        }
        add(comboSahalar);

        // İsim Soyad
        add(new JLabel("Müşteri Ad Soyad:"));
        txtAdSoyad = new JTextField(20);
        add(txtAdSoyad);

        // Tarih
        add(new JLabel("Tarih ve Saat Giriniz:"));
        txtSaat = new JTextField(20);
        txtSaat.setText("03.12.2025 20:00"); // Örnek veri
        add(txtSaat);

        // Kaydet Butonu
        JButton btnKaydet = new JButton("Randevuyu Oluştur");
        btnKaydet.setBackground(Color.GREEN); // Yeşil buton
        add(btnKaydet);

        // Sonuç Ekranı
        txtSonuc = new JTextArea(8, 28);
        txtSonuc.setEditable(false);
        add(new JScrollPane(txtSonuc));

        // --- 4. BUTON AKSİYONU ---
        btnKaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ad = txtAdSoyad.getText();
                String tarih = txtSaat.getText();
                HaliSaha secilenSaha = (HaliSaha) comboSahalar.getSelectedItem();

                if (ad.isEmpty() || tarih.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lütfen bilgileri eksiksiz girin!");
                    return;
                }

                // Müşteri nesnesi oluştur (ID şimdilik rastgele 1)
                Musteri musteri = new Musteri(1, ad, "555-0000");

                // Sisteme kaydet
                sistem.randevuOlustur(secilenSaha, musteri, tarih);

                // Ekrana yaz
                txtSonuc.append("✔ " + secilenSaha.getIsim() + "\n");
                txtSonuc.append("👤 " + ad + "\n");
                txtSonuc.append("🕒 " + tarih + "\n");
                txtSonuc.append("-----------------------\n");

                // Temizlik
                txtAdSoyad.setText("");
            }
        });

        setLocationRelativeTo(null); // Ekranın ortasında aç
        setVisible(true);
    }

    public static void main(String[] args) {
        // Arayüzü güvenli modda başlatır
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Uygulama();
            }
        });
    }
}