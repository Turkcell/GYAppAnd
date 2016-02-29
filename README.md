# Geleceği Yazanlar Android Uygulaması

![Geleceği Yazanlar Uygulaması](https://gelecegiyazanlar.turkcell.com.tr/sites/default/files/burrrak_0.jpg)

Uygulamayı Google Play üzerinden indirmek için: https://play.google.com/store/apps/details?id=com.turkcell.gelecegiyazanlar

Bu proje Geleceği Yazanlar elçilerinden 7 üniversite öğrencisinin bir araya gelip Android öğrenerek dört haftada geliştirdiği bir android uygulamasıdır. Projenin amacı Geleceği Yazanlar üyelerinin Android uygulamasıyla platformdaki kullanıcı girişi gerektirmeyen;

•	Eğitimler (Mobil - Web - Oyun)<br />
•	Etkinlikler<br />
•	Blog<br />
•	Profil sayfaları<br />
•	Site içi arama<br />

sayfalarına daha rahat ulaşmasını sağlamaktır. <br />

Uygulamamızı geliştirirken hafta hafta blog yazıları ile neler yaşadığımızı anlattık;<br />

•	[1. hafta](https://gelecegiyazanlar.turkcell.com.tr/blog/mobil-uygulamamizi-gelistiriyoruz-1.-hafta)<br />
•	[2. hafta](https://gelecegiyazanlar.turkcell.com.tr/blog/mobil-uygulamamizi-gelistiriyoruz-2.-hafta)<br />
•	[3. hafta](https://gelecegiyazanlar.turkcell.com.tr/blog/mobil-uygulamamizi-gelistiriyoruz-3.-hafta)<br />
•	[4. hafta](https://gelecegiyazanlar.turkcell.com.tr/blog/mobil-uygulamamizi-gelistiriyoruz-4.-hafta)<br />


####Uygulama geliştiricileri:<br />

•	[Abdullah Sarıkaya](https://gelecegiyazanlar.turkcell.com.tr/kisi/haciabdullahsarikaya): Eğitim sayfası,<br />
•	[Doğukan Yıldırım](https://gelecegiyazanlar.turkcell.com.tr/kisi/dyildirim76): Etkinlik sayfası,<br />
•	[Gizem Nur Yurdagül](https://gelecegiyazanlar.turkcell.com.tr/kisi/gizemnuryurdagul): Yorumlar sayfası,<br />
•	[Kadirhan Ekmekçioğlu](https://gelecegiyazanlar.turkcell.com.tr/kisi/kadirhann21): Blog sayfası,<br />
•	[Volkan Kılıç](https://gelecegiyazanlar.turkcell.com.tr/kisi/volkankilic): Geliştiriciler sayfası,<br />
•	[Taner Utku](https://gelecegiyazanlar.turkcell.com.tr/kisi/tanerutku): Profil sayfası,<br />
•	[Yusuf Eren Utku](https://gelecegiyazanlar.turkcell.com.tr/kisi/yerenutku): Arama sayfası<br />

Proje ile ilgili hata ve eksikliklerin düzeltilip, projenin geliştirilmesi için projeyi GitHub'da paylaşmaya karar verdik. Geliştirilmesine katkıda bulunan herkese teşekkür ederiz.


## Projenin Genel Yapısı Hakkında Bilgiler

####Fragment Yapısı

Öncelikle uygulamamızı Android Studio IDE’si ile geliştirildi. Uygulama sayfa düzeni açısından Activityler ve Fragmentlar olarak hiyerarşik bir yapıdadır.

İlk açılan sayfamız MainActivitydir. Fakat içerisinde EğitimFragment adında bir fragment dönüyor. Bu fragment ise kendi içerisinde tablar ile geçiş yaparak dönen 3 farklı eğitim kategorisi fragmentlarını döndürmektedir. Bunlar ise; Mobil,Oyun ve Web Fragmentlarıdır.

Devamında sol taraftan açılan hamburger menü listemiz de MainActivity içersinde DrawerLayout olarak bulunuyor. Listemizde ki menü isimleriyle BlogFragment,

EtkinlikFragment gibi diğer sayfalara geçişler sağlanmaktadır. Ayrıca arama sayfamızı da AramaActivity içerisinden inceleyebilirsiniz.

####Material Design

Uygulamamız Google’ın son çıkardığı design yani Material Design kullanımına uyumludur.

Bunu yapabilmek için ise kütüphane olarak ‘com.android.support:design:22.2.0’

kütüphanesini projemize ekledik.

Çünkü uygulamamızda bu designa ait bileşenlerden, renk yapısından ve animasyonlarından yararlandık.

Material Design kullanımı ile ilgili aşağıdaki yazıyı inceleyebilirsiniz: 

http://android-developers.blogspot.com.tr/2015/05/android-design-support-library.html



####Recyclerview & Cardview

Listeleme ve kart görünümünde sayfalar oluşturmak için layout dosyamızda RecyclerView ve CardView widgetlarını kullandık.Bu özellik için ‘com.android.support:recyclerview-v7:22.2.0’ ve ‘com.android.support:cardview-v7:22.2.0’  kütüphanelerini projeye ekledik. Blog ve Etkinlik sayfalarında nasıl kullanıldığını inceleyebilirsiniz.

RecyclerView ve Cardview kullanımı ile ilgili inceleyebilceğiniz bir yazı: 

https://lokeshcodes.wordpress.com/2015/09/22/recycler-view-with-cardview/



####CircleImageView

Dairesel ve özel fotoğraf yapıları oluşturmak için hazır olarak CircleImageView 'de.hdodenhof:circleimageview:1.3.0' kütüphanesinden yararlandık.

CircleImageView ile ilgili ayrıntılı dökümana aşağıdaki linkten ulaşabilirsiniz:

https://github.com/hdodenhof/CircleImageView

####Floating Action Button

Profil ve bize ulaşın sayfasında sağ alt taraftaki butona tıkladığınızda size seçenek butonları çıkıyor. Bu yapı için Floating Action Button ‘com.getbase:floatingactionbutton:1.10.0’ kütüphanesini projemize ekledik.

Floating Action Button kütüphanesi ile ilgili ayrıntılı dökümana aşağıdaki linkten ulaşabilirsiniz:

https://github.com/futuresimple/android-floating-action-button



 

####Volley

Uygulama içerisindeki Bloglar, Etkinlikler, Eğitimler gibi bir çok bölüm dinamik olarak geliyor. Site üzerindeki dinamik olarak gelen verileri uygulamada kullanabilmek için servisler yani API’lar yazılmıştı. Bu API’lar bize json çıktıları üretmektedir. Gelen verileri uygulamaya parse etmek için Google’ın Volley kütüphanesinden yararlandık.

Bu kütüphaneyi kullanmak için projeye; ‘eu.the4thfloor.volley:com.android.volley:2015.05.28’ kütüphanesini projeye dahil ederek Volley’i kullandık.

Volley küphanesi ile ilgili dökümana aşağıdaki linkten ulaşabilirsiniz: 

https://github.com/the4thfloor/volley

####Turkcell CurioSDK

Turkcell’in geliştirmiş olduğu CurioSDK kullanılarak kullanıcı ve veri analitiği sağlanabilmektedir. Bunu kullanabilmek için ise curiosdk.jar dosyasını projemize ekledik.

CurioSDK ile ilgili dökümana aşağıdaki linkten ulaşabilirsiniz:  

https://github.com/Turkcell/Curio_android_SDK_Gradle

####Splunk MINT SDK

Projemizde herhangi bir hata alındığında bilgimiz olması için Splunk MINT SDK’i kullandık. Projemize  'com.splunk.mint:mint:4.4.0' kütüphanesini ekledik.

MINT SDK ile ilgili dökümana aşağıdaki linkten ulaşabilirsiniz: 

http://docs.splunk.com/Documentation/MintAndroidSDK/latest/DevGuide/Requirementsandinstallation
