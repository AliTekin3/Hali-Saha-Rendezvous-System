import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Uygulama extends JFrame {

    private JComboBox<HaliSaha> comboSahalar;
    private JComboBox<String> comboSaatler;
    private JTextField txtAdSoyad;
    private JTable tablo;
    private DefaultTableModel tabloModeli;
    private JButton btnSil;
    private RandevuSistemi sistem;

    public Uygulama() {
        sistem = new RandevuSistemi();
        sistem.sahaEkle(new HaliSaha("Bostanbükü", "Merkez", 1500.0));
        sistem.sahaEkle(new HaliSaha("Karşıyaka", "Sanayi", 1200.0));
        sistem.sahaEkle(new HaliSaha("Kayalar", "Kampüs", 1350.0));

        setTitle("Halı Saha Randevu Sistemi v2.3");
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("Halı Saha Seçiniz:"));
        comboSahalar = new JComboBox<>();
        for (HaliSaha saha : sistem.getSahalar()) {
            comboSahalar.addItem(saha);
        }
        panelForm.add(comboSahalar);

        panelForm.add(new JLabel("Müşteri Ad Soyad:"));
        txtAdSoyad = new JTextField();

        ((AbstractDocument) txtAdSoyad.getDocument()).setDocumentFilter(new DocumentFilter() {
            private boolean harfKontrol(String text) {
                return text.matches("[a-zA-ZçğıöşüÇĞİÖŞÜ\\s]+");
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string != null && harfKontrol(string)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text != null && harfKontrol(text)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        panelForm.add(txtAdSoyad);

        panelForm.add(new JLabel("Randevu Saati:"));
        String[] saatler = new String[24];
        for (int i = 0; i < 24; i++) {
            int baslangic = i;
            int bitis = (i + 1) % 24;
            saatler[i] = String.format("%02d:00 - %02d:00", baslangic, bitis);
        }
        comboSaatler = new JComboBox<>(saatler);
        panelForm.add(comboSaatler);

        JButton btnKaydet = new JButton("Randevu Ekle");
        btnKaydet.setBackground(new Color(60, 179, 113));
        btnKaydet.setForeground(Color.BLACK);
        panelForm.add(new JLabel(""));
        panelForm.add(btnKaydet);

        add(panelForm, BorderLayout.NORTH);

        String[] kolonlar = {"Saha Adı", "Müşteri", "Saat", "Ücret"};
        tabloModeli = new DefaultTableModel(kolonlar, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablo = new JTable(tabloModeli);
        tablo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(tablo);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelAlt = new JPanel();
        btnSil = new JButton("Seçili Randevuyu İptal Et");
        btnSil.setBackground(new Color(220, 53, 69));
        btnSil.setForeground(Color.BLACK);
        panelAlt.add(btnSil);

        add(panelAlt, BorderLayout.SOUTH);

        btnKaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ad = txtAdSoyad.getText();
                String saat = (String) comboSaatler.getSelectedItem();
                HaliSaha secilenSaha = (HaliSaha) comboSahalar.getSelectedItem();

                if (ad.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lütfen isim giriniz!");
                    return;
                }

                Musteri musteri = new Musteri(1, ad, "555-0000");
                String tamTarih = "08.12.2025 " + saat;

                boolean sonuc = sistem.randevuOlustur(secilenSaha, musteri, tamTarih);

                if (sonuc) {
                    Object[] satir = {
                            secilenSaha.getIsim(),
                            ad,
                            saat,
                            secilenSaha.getSaatlikUcret() + " TL"
                    };
                    tabloModeli.addRow(satir);
                    txtAdSoyad.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "HATA: Bu saat dolu!", "Çakışma", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnSil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int seciliSatir = tablo.getSelectedRow();

                if (seciliSatir == -1) {
                    JOptionPane.showMessageDialog(null, "Lütfen iptal etmek için listeden bir randevu seçin.");
                    return;
                }

                String sahaAdi = (String) tabloModeli.getValueAt(seciliSatir, 0);
                String saat = (String) tabloModeli.getValueAt(seciliSatir, 2);

                String tamTarih = "08.12.2025 " + saat;

                boolean silindiMi = sistem.randevuIptal(sahaAdi, tamTarih);

                if (silindiMi) {
                    tabloModeli.removeRow(seciliSatir);
                    JOptionPane.showMessageDialog(null, "Randevu iptal edildi.");
                } else {
                    JOptionPane.showMessageDialog(null, "Silme işlemi sırasında hata oluştu.");
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
        SwingUtilities.invokeLater(() -> new Uygulama());
    }
}
