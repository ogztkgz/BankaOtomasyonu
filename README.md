Banka otomasyon programı çalıştırıldığında kulllanıcının karşısına hesap oluşturma, para çekme, 
para yatırma, sistem tarihini değiştirme, tüm hesapların id'sini görme, son 5 işlemi görme ve çekiliş gibi 
şıkları sunan 10 seçenekli bir menü yapısı çıkartıyor.
Bu menüde kullanıcıya ;
4 tip hesap oluşturma seçeneği ile
1-Create_Short_ID_balance(Hesap no, başlangıç parası)
2-Create_Long_ID_balance(Hesap no, başlangıç parası)
3-Create_Special_ID_balance(Hesap no, başlangıç parası)
4-Create_Current_ID_balance(Hesap no, başlangıç parası)
createAccounts() fonksiyonu kullanan; kısa vadeli, uzun vadeli, özel ve cari hesap oluşturma seçenekleri
2 tip para yönetimi seçeneği ile 
5-Increase_ID_cash(Id)
6-Decrease_ID_cash(Id)
if else yapıları kullanarak controlAccountId ,deposit, withdraw fonksiyonları ile para yatırma ve para 
çekme seçenekleri
Sistem tarihi değiştirme seçeneği ile
7-Change System Date
changeSystemDate() fonksiyonu ile sistemde halihazırda tanımlanmış tarihi(5.5.2023) istediği tarihle 
değiştirme seçeneği
2 tip hesap bilgisi seçeneği ile
8-Show Accounts Id And Last 5 Transactions
9-Show accounts Id
showAccounts() getAccouts() fonksiyonları ile tüm hesapların id'lerini, işlem yapılmış son 5 hesabın id ve 
yapılan işlemi görme seçenekleri
Çekiliş seçeneği ile
10-Sortition
sortition() fonksiyonu ile özel hesapların arasında kazananın 10000 tl alacağı bir çekiliş yapabilme 
seçeneği sunan
menü yapısı ile kullanıcının istediği işlemi seçip uygulamasını sağlayan, 2 sınıf yapısı(Account, Bank), 23 
fonksiyon (tanımlama raporunda belirtilen) kullanılan, 18 değişken (tanımlama raporunda belirtilen) 
kullanılan, bir veri yapısı kullanılmadığı için yalnızca program çalıştırılırken girilen bilgileri kullanan bir 
banka otomasyon programıdır
