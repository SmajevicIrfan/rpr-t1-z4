# RPR Tutorijal 1 2018/2019. Zadatak 4

U projektu trebaju postojati klase Student, Predmet i Program (možete kreirati i druge klase po potrebi). Klasa Program treba sadržavati metodu main koja omogućuje: kreiranje novog predmeta, novog studenta, upis studenta na predmet, ispis studenta sa predmeta, brisanje studenta, brisanje predmeta, te ispis spiska studenata na predmetu. 

Klasa Predmet treba u privatnom atributu držati niz studenata, te treba sadržavati metode: upisi i ispisi koje primaju referencu na studenta. Podaci o predmetu su: naziv predmeta, šifra predmeta i maksimalan broj studenata. Podaci o studentu su: ime, prezime i broj indeksa. Svi ovi podaci se trebaju zadavati pomoću konstruktora, te se trebaju moći mijenjati pomoću gettera i settera (osim maksimalnog broja studenata na predmetu koji se ne može mijenjati).

Klase trebaju podržavati ispis studenta na ekran u obliku:
```
	Prezime Ime (brindexa)
```
koristeći kod oblika
```java
	System.out.println(s);
```
(gdje je s referenca na klasu Student).

Također klasa Predmet treba omogućavati ispis spiska studenata upisanih na predmet oblika:
```
	1. Prezime Ime (brindexa)
	2. Prezime Ime (brindexa)
	3. Prezime Ime (brindexa)
	…
```
1, 2 i 3 su redni brojevi studenata na spisku.

## Za sljedeci tutorijal

Dodati JUnit testove za koje smatrate da su korisni.
