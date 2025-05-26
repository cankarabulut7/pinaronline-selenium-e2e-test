# PinarOnline Otomasyon Testleri

Bu proje, PinarOnline web sitesinin çeşitli fonksiyonlarını otomatik olarak test etmek için Selenium WebDriver ve TestNG kullanılarak Java dilinde geliştirilmiş UI test otomasyon projesidir.

---

## Test Edilen Modüller

1. **LoginPage (Giriş Yapma Testleri)**  
   - Kullanıcının telefon numarasıyla giriş yapabilmesi  
   - OTP (Tek Kullanımlık Şifre) doğrulaması  
   - Giriş sonrası kullanıcı profil ikonunun görünürlüğü ile doğrulama  

2. **CategoryAndProductPage (Kategori ve Ürün Testleri)**  
   - Kategori barının açılması  
   - Rastgele kategori seçimi  
   - Rastgele ürün seçimi  
   - Ürün detay sayfasına yönlendirilme kontrolü  

3. **BasketPage (Sepet Testleri)**  
   - Ürün sepete ekleme  
   - Sepete ekleme bildiriminin doğrulanması  
   - Sepet içerisindeki ürün adet arttırma/azaltma  
   - Sepete gidip ürünün görüntülenmesi  
   - Sepetten ürün silme  

4. **PromotionsPage (Kampanya Testleri)**  
   - Kampanya sayfasına navigasyon  
   - Kampanya görsellerinin yüklenme doğrulaması  

---

## Proje Yapısı

- **`pages`**: Sayfa nesne modeli (Page Object Model) mantığıyla yazılmış, web sayfasındaki elementlerin ve fonksiyonların tanımlandığı sınıflar.  
- **`tests`**: Test senaryolarının yer aldığı paket. TestNG framework'ü kullanılarak organize edilmiştir.  
- **`util`**: WebDriver yönetimi gibi yardımcı fonksiyon ve sınıflar.

---

## Kullanılan Teknolojiler ve Araçlar

- **Java 17+**  
- **Selenium WebDriver**  
- **TestNG**  
- **Maven veya Gradle** (proje bağımlılık ve yönetimi için)  
- **Explicit Wait (WebDriverWait)** ile senkronizasyon yönetimi  

---

## Nasıl Çalıştırılır?

1. Projeyi GitHub veya kaynak ortamından klonlayın.  
2. IDE içerisinde projeyi açın (IntelliJ IDEA, Eclipse vb.).  
3. `BaseTest` sınıfında tanımlı olan temel URL (`https://testrio.pinaronline.com`) kontrol edin, gerekirse değiştirin.  
4. Test sınıflarını test framework'ünüzden (TestNG) çalıştırın.

Komut satırı ile Maven kullanıyorsanız:

```bash
mvn test



