### Proje Dökümanı

Proje Spring Boot kullanılarak yapılmıştır.

İlk olarak projeye gerekli olan bağımlılıklar build.gradle'a eklenmiştir.
Ardından Gerekli olan modüller eklenip application.yml dosyası resources
modülüne eklenmiştir. application.yml'a girip kendi database bilgilerinizi
yazarak projeyi kendi database'inize ekleyebilirsiniz.
ddl-auto kısmı ilk olarak create olarak belirlenmelidir. Böylece tablolar
yaratılabilir. Ardından update olarak belirlenip işlemlere devam edilebilir.
Projede işlemler swagger.ui üzerinden yapılabilir. Swagger sayfasına ;
http://localhost:8090/swagger-ui/index.html#/ aracılığı ile ulaşabilirsiniz.
Company ve Employee sınıfı için create işlemlerinden sonra findAll ve findById
metodları ile aradığınız şirket ve çalışanı bulabilir. Update metodu ile 
bilgileri değiştirebilirsiniz. 

Create işleminden sonra utility paketindeki
DataIml class'ına gidip setEmployeeByCompanyId metodunun başındaki yorum 
satırını kaldırıp projeyi tekrardan çalıştırdığınızda company ve employee
verilerini bir arada company_employee_id tablosunda görebilirsiniz.
Ayrıca findByCompanyId metodu ile bir şirkette hangi çalışanların çalıştığını görebilirsiniz.

İlginiz için teşekkür ederim.
