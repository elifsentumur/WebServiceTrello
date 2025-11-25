# Service Test Çalışması

## Açıklama
Bu proje, Trello için CRUD test otomasyonlarını içerir.

Trello API Anahtarı ve Token Oluşturma Adımları
1. Power-Up’lar ve Entegrasyonlar sayfasına gidin
https://trello.com/power-ups/admin
2. “Yeni” butonuna tıklayın. 3. Açılan formu doldurup “Oluştur” seçeneğini seçin.
4. Karşınıza çıkan pencerede “Yeni bir API anahtarı oluşturun” butonuna tıklayın. a. Bu alanda görüntülenen değer, API Anahtarınızdır. 5. Token oluşturmak için aynı sayfada yer alan
“manuel olarak bir Belirteç (Token) oluşturabilirsiniz.” ifadesindeki “Belirteç” bağlantısına tıklayın. 6. Gerekli izinleri verin ve oluşan değeri kopyalayın. a. Bu değer, uygulamanızda kullanacağınız yeni Tokendır. 7. Artık Trello REST API’sini kullanmaya hazırsınız. Ayrıntılı uç nokta bilgileri ve örnek istekler için:
https://developer.atlassian.com/cloud/trello/rest/

https://home.atlassian.com/
https://trello.com/power-ups/6925873b222cdab27f3184e0/edit/api-key
https://developer.atlassian.com/cloud/trello/rest/api-group-boards/#api-boards-post
https://developer.atlassian.com/cloud/trello/rest/api-group-actions/#api-group-actions
## Test Senaryoları
 - Trello üzerinde bir board oluşturunuz.
 - Oluşturduğunuz board’a iki tane kart oluşturunuz.
 - Oluşturduğunuz bu iki karttan random olacak sekilde bir tanesini
güncelleyiniz.
 - Oluşturduğunuz kartları siliniz.
 - Oluşturduğunuz board’u siliniz.
 
## Çalıştırma Talimatları
1. Repo’yu klonlayın: `git@github.com:elifsentumur/WebServiceTrello.git`
2. Gerekli bağımlılıkları yükleyin
3. Testleri çalıştırın: `mvn test`  
4. Test sonuçları konsolda görüntülenmektedir
