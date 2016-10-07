###Aihemäärittely

**Aihe:** 

Shakki. Toteutetaan shakkipeli, jossa kaksi pelaajaa pelaa toisiaan vastaan. 

Peli muodostuu 8x8 ruudukon kokoisesta shakkilaudasta, jolla kummallakin pelaajalla on aluksi 16 pelinappulaa: 1 kuningas, 1 kuningatar, 2 lähettiä, 2 ratsua, 2 tornia ja 8 sotilasta. Jokainen näistä nappulatyypeistä liikkuu eri tavalla. Pelaajat siirtävät vuorotellen aina yhtä omaa nappulaansa, jota voi siirtää joko tyhjään ruutuun tai ruutuun, jossa on vastustajan nappula, jolloin tämä nappula tulee lyödyksi ja se poistetaan laudalta. 

Pelin tavoite on saattaa vastustajan kuningas shakkimattiin eli tilanteeseen, jossa kuningas on uhattuna, eikä vastapelaajalla ole käytössään laillisia siirtoja uhkauksen, eli shakin, torjumiseksi. Peli voi lisäksi päättyä jomman kumman pelaajan luovuttamiseen tai tasapeliin. Peli päättyy tasapeliin silloin, kun 
- siirtovuorossa olevalla pelaajalla ei ole sallittuja siirtoja, eikä kuningas ole uhattuna
- pelaajat niin sopivat tai
- pelaaja omalla vuorollaan vaatii tasapeliä, kun laudalla on täsmälleen sama asema vähintään kolmatta kertaa tai on pelattu 50 siirtoa ilman, että yksikään sotilas on liikkunut ja yhtään nappulaa on lyöty tai 
- kummallakaan pelaajalla ei ole riittävästi materiaalia shakkimatin tekemiseen

**Käyttäjät:** Kaksi pelaajaa

**Käyttäjän toiminnot:**

- Uuden pelin aloittaminen
- Siirron tekeminen
- Tasapelin ehdottaminen
- Tasapeliin suostuminen
- Luovuttaminen
  - Vaatii vahvistuksen

![luokkakaavio](http://yuml.me/9ad82764 "Määrittelyvaiheen luokkakaavio")

![sekvenssikaavio](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=dGl0bGUgTGFpbGxpc2VuIHNpaXJyb24gdGVrZW1pbmVuCgpDaGVzcy0-Qm9hcmQ6IGdldFBpZWNlKGZyb20pCgARBSAtLT4gACIFOiBtb3ZpbmcAHgUAIhh0bwAlE2NhcHR1cmVkADQGAG0IAGYFOiBsZWdhbE1vdgBwBiwgdG8sIGJvYXJkKQoAgQgFLS0-AHgHdHJ1AG8JADYHZ2V0Q29sb3IoABwRABIFAGIJbGF5ZXIAgTkIT3duAIFhBgCBRQspCgAeBgBkCmZhbHMAgSMKAIIbB3MAghoIAIIACywgdG8pABAYbnVsbCwgAIJKBgB-D2NoYW5nZVR1cm4oKQoK&s=napkin "Laillisen siirron tekeminen")

![sekvenssikaavio](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=dGl0bGUgTGFpdHRvbWFuIHNpaXJyb24geXJpdHTDpG1pbmVuCgpDaGVzcy0-Qm9hcmQ6IGdldFBpZWNlKGZyb20pCgARBSAtLT4gACIFOiBtb3ZpbmcAHgUAIhh0bwAlE2NhcHR1cmVkADQGAG0IAGYFOiBsZWdhbE1vdgBwBiwgdG8sIGJvYXJkKQoAgQgFLS0-AHgHZmFscwBwCVNjcmVlbjogVmlyaGVpbG1vaXR1cwCBXQllcMOkb25uaXN0dW1pc2VzdGEKCg&s=napkin "Laittoman siirron yrittäminen")
