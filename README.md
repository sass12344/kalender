# Hoiatus! Nüüd arendatakse edasi [siin](https://github.com/misteha/kalender)

# Tegevuste planeerija - OOP kevad 2025
*Uku Mihkel Kolka (MisTeha), Jesper Korsen (YesterKo), Sander Sarapuu (sass12344)*

Funktsionaalsus:
- Graafiline liides, millega saab kirja panna ülesandeid koos tähtaegadega. GUI annab kasutajale ülevaate tulevastest ja möödunud tegevustest.
- Ülesanded võivad olla ka üksteisest sõltuvad või olla teise ülesande alamülesanded. "Ülesanded" võivad olla ka sündmuse tüüpi, ehk lõpetamist nad ei nõua.
- Rakendusega kaasneb ka daemon, mis saadab läbi OS-i teavitusi.
- Rakendusega kaasneb ka server, mille abil saab oma tegevusi sünkroniseerida erinevate seadmete vahel.
    - Server võib saata ka e-posti teel teavitusi.
- Serveri kaudu saab ka jagada tegevusi erinevate kasutajate vahel või isegi määrata ülesande teisele kasutajale.
    - Muudatustest antakse teada e-posti teel.
- Ligipääsu ülesannetele (ja kasutajakontosid, turvalisust) tagab server.
- Saab subscribeida online ical kalendritele ja updateida neid
