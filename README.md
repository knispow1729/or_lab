# Otvoreni skup podataka o Dota2 turnirima. 

## Model baze podataka otvorenog skupa podataka za Dota2 turnirima.
Podacima se modelira pojedinačni turnir te sponzori i njihov odnos koji odgovara many-to-many relaciji. Za te svrhe se u bazi podataka stvara spojna tablica `turnir_sponzor`.
Time se baza podataka sastoji od tablica `turniri` , `sponzori ` i `turnir_spoznor`. Podaci iz baze izvezeni su naredbom COPY u alatu psql i nalaze se u datotekama `json_query.txt` i `csv_query.txt`.

<a rel="license" href="http://creativecommons.org/licenses/by/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by/4.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/4.0/">Creative Commons Attribution 4.0 International License</a>.



### Naziv autora: Juraj Vrdoljak
### Verzija: 1.0
### Jezik podataka: engleski
### Opis atributa skupa podataka
| Atribut | Opis |
| ----------- | ----------- |
| Naziv | Naziv turnira |
| Serija | Naziv serije turnira pod kojom se turnir održava |
| Organizator | Lista organizatora turnira. Organizatori mogu, ali i ne moraju biti sponzori turnira|
| Tip | Održava li se turnir na LAN mreži (offline) ili preko mreže (online) |
| Lokacija | Mjesto održavanja turnira, ukoliko nije fizička lokacija onda je preko mreže (Internet) |
| Format | Format pod kojim se igra turnir |
| Nagradni fond | Iznos nagradnog fonda u američkim dolarima |
| Broj Timova | Broj timovak koji sudjeluju na turniru |
| Datum pocetka | Datum početka turnira |
| Datum zavrsetka | Datum završetka turnira |
| Verzija igre | Verzija igre na kojoj će se igrati |
| Broj Gledatelja | Maksimalni ukupan broj gledatelja turnira na svim platformama|
| Sponzori.Naziv | Ime sponzora turnira|
| Sponzori.Iznos | Iznos koji sponzor dodjeljuje turniru|

