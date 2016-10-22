###Aihemäärittely

**Aihe:** 

Shakki. Toteutetaan shakkipeli, jossa kaksi pelaajaa pelaa toisiaan vastaan. 

Peli muodostuu 8x8 ruudukon kokoisesta shakkilaudasta, jolla kummallakin pelaajalla on aluksi 16 pelinappulaa: 1 kuningas, 1 kuningatar, 2 lähettiä, 2 ratsua, 2 tornia ja 8 sotilasta. Jokainen näistä nappulatyypeistä liikkuu eri tavalla. Pelaajat siirtävät vuorotellen aina yhtä omaa nappulaansa, jota voi siirtää joko tyhjään ruutuun tai ruutuun, jossa on vastustajan nappula, jolloin tämä nappula tulee lyödyksi ja se poistetaan laudalta. Pelin tavoite on lyödä vastustajan kuningas

**Käyttäjät:** Kaksi pelaajaa

**Käyttäjän toiminnot:**

- Uuden pelin aloittaminen
- Siirron tekeminen
- Sotilaan korottaminen

![luokkakaavio](http://yuml.me/9ad82764 "Määrittelyvaiheen luokkakaavio")

**Rakennekuvaus:**
Luokassa Chess sijaitsee varsinainen pelin etenemiseen liittyvä logiikka, joten se tuntee pelilaudan (ChessBoard) sekä pelaajat Player-rajapinnan kautta. Lisäksi se pitää kirjaa erityistilanteista ja käyttää tekstikäyttöliittymää. 

Pelilauta puolestaan tietää pelissä mukana olevat nappulat sekä niiden sijainnit laudalla (Square). Kaikki nappulat toteuttavat abstraktin luokan Piece, jossa on määritelty niiden yleinen liikkumislogiikka. Jokaisen nappulan omassa luokassa on sitten tarkennettu liikkumissääntöjä nappulan erityispiirteillä. Jokaisella nappulalla on myös väri, joka voi olla musta tai valkoinen. Varsinaiset siirrot tehdään Chess-luokassa, jossa myös tarkistetaan, ettei pelajaa lyö omia nappuloitaan tai liikuta toisen pelaajan nappuloita.


![sekvenssikaavio](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=dGl0bGUgTGFpbGxpc2VuIHNpaXJyb24gdGVrZW1pbmVuCgpDaGVzcy0-Qm9hcmQ6IGdldFBpZWNlKGZyb20pCgARBSAtLT4gACIFOiBtb3ZpbmcAHgUAIhh0bwAlE2NhcHR1cmVkADQGAG0IAGYFOiBsZWdhbE1vdgBwBiwgdG8sIGJvYXJkKQoAgQgFLS0-AHgHdHJ1AG8JADYHZ2V0Q29sb3IoABwRABIFAGIJbGF5ZXIAgTkIT3duAIFhBgCBRQspCgAeBgBkCmZhbHMAgSMKAIIbB3MAghoIAIIACywgdG8pABAYbnVsbCwgAIJKBgB-D2NoYW5nZVR1cm4oKQoK&s=napkin "Laillisen siirron tekeminen")

![sekvenssikaavio](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=dGl0bGUgTGFpdHRvbWFuIHNpaXJyb24geXJpdHTDpG1pbmVuCgpDaGVzcy0-Qm9hcmQ6IGdldFBpZWNlKGZyb20pCgARBSAtLT4gACIFOiBtb3ZpbmcAHgUAIhh0bwAlE2NhcHR1cmVkADQGAG0IAGYFOiBsZWdhbE1vdgBwBiwgdG8sIGJvYXJkKQoAgQgFLS0-AHgHZmFscwBwCVNjcmVlbjogVmlyaGVpbG1vaXR1cwCBXQllcMOkb25uaXN0dW1pc2VzdGEKCg&s=napkin "Laittoman siirron yrittäminen")
