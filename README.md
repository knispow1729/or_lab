# Otvoreni skup podataka o Dota2 turnirima. 

Podacima se modelira pojedinačni turnir te sponzori i njihov odnos koji odgovara many-to-many relaciji. Za te svrhe se u bazi podataka stvara spojna tablica `turnir_sponzor`.
Time se baza podataka sastoji od tablica `turniri` , `sponzori ` i `turnir_spoznor`. Podaci iz baze izvezeni su naredbom COPY u alatu psql i nalaze se u datotekama `json_query.txt` i `csv_query.txt`.


<a rel="license" href="http://creativecommons.org/licenses/by/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by/4.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/4.0/">Creative Commons Attribution 4.0 International License</a>.

 
