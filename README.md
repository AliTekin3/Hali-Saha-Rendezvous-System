# ⚽ Halı Saha Randevu Sistemi (Turf Reservation System)

Bu proje, **Yazılım İnşası (Software Construction)** dersi kapsamında; Nesne Yönelimli Programlama (OOP) prensipleri, temiz kod (Clean Code) standartları ve Katmanlı Mimari kullanılarak geliştirilmiştir.

## 🚀 Proje Hakkında
Sistem, halı sahaların yönetimini ve müşteri rezervasyon süreçlerini dijitalleştirmek amacıyla tasarlanmıştır. Proje, kod karmaşasını önlemek ve sürdürülebilirliği artırmak adına 4 temel katmana ayrılmıştır:

1.  **Varlık Katmanı (Entity Layer):** Sistemdeki temel nesnelerin (Saha, Müşteri, Rezervasyon) modellendiği katman.
2.  **Veri Katmanı (Data Access Layer):** Verilere erişim sağlayan ve `Interface` yapısı ile soyutlanmış katman.
3.  **İş Mantığı Katmanı (Business Logic Layer):** Çakışma kontrollerinin ve rezervasyon kurallarının yönetildiği katman.
4.  **Sunum Katmanı (Presentation/GUI Layer):** Kullanıcı ile etkileşime giren Java Swing arayüzü.

## 🛠️ Kullanılan Teknolojiler ve Prensipler
* **Dil:** Java SE (JDK 17+)
* **Arayüz:** Java Swing (GUI)
* **Mimari:** Layered Architecture (N-Tier) & Interface-Based Programming
* **Prensipler:**
    * Encapsulation (Kapsülleme)
    * Separation of Concerns (İlgi Alanlarının Ayrılması)
    * Loose Coupling (Gevşek Bağlılık - Interface kullanımı ile)

## ✨ Özellikler
* ✅ Dinamik halı saha ekleme ve listeleme
* ✅ Müşteri ve rezervasyon yönetimi
* ✅ **Akıllı Çakışma Kontrolü:** Aynı saate mükerrer randevu verilmesini engeller.
* ✅ Genişletilebilir veritabanı altyapısı (Interface yapısı sayesinde).
* ✅ Kullanıcı dostu görsel arayüz.

## 👥 Proje Ekibi
Proje geliştirme süreci modüler olarak iş bölümüyle gerçekleştirilmiştir:
* **Backend & Entities:** [Ali Tekin]
* **Database Interface & Mock Data:** [Burak Kahramanöz]
* **Business Logic & Validation:** [Alihan Toprak Arslan]
* **Frontend (GUI) & Integration:** [Melih Can Sağ]

---
