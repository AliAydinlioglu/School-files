--  Toon een alfabetische adreslijst van alle leveranciers (naam, leverancierscode, adres en woonplaats).
--  Sorteer op woonplaats in dalende volgorde. Bij gelijke woonplaats komen de namen van de leveranciers in alfabetische volgorde.
SELECT naam, levCode, adres, woonplaats    
FROM leveranciers 
ORDER BY woonplaats DESC, naam;

--  Toon de unieke leverancierscodes van de leveranciers waarbij bestellingen zijn geplaatst.
SELECT DISTINCT levCode
FROM leveranciers;

--  Geef een alfabetische lijst van alle planten (naam) waarvan de naam eindigt op bloem
select distinct naam
from planten where naam like '%bloem'
order by naam;

-- Geef een overzicht (alle gegevens) van alle leveranciers die wonen te Antwerpen, Heusden of Leuven.
select *
from leveranciers
where woonplaats in ('Antwerpen', 'Heusden', 'Leuven');

-- Toon de naam, artikelcode en prijs van de planten waarvan de bloei begint in april. 
select naam, artCode, prijs
from planten
where bl_b = 4;

-- Geef een overzicht van alle planten waarvan de bloeiperiode begin en/of bloeiperiode einde niet is ingevuld.
-- Toon de naam van de planten en een aanduiding,
-- gebruik hiervoor een case expressie en noem de kolom "bloeiperiode", de volgende aanduidingen zijn mogelijk:

-- Beginperiode niet opgegeven: indien enkel bl_b niet is ingevuld
-- Eindperiode niet opgegeven: indien enkel bl_e niet is ingevuld
-- Periodes niet opgegeven: indien beide niet ingevuld
select naam,
case 
when bl_b is null and not bl_e is null
	then'beginperiode niet opgegeven' 
WHEN NOT bl_b is null AND bl_e is null		THEN 'eindperiode niet opgegeven'
	ELSE 'periodes niet opgegeven' 
end as 'bloeiperiode'
FROM planten  
WHERE bl_e is null OR bl_b is null;

-- Toon de bestelnummers van de bestellingen voor een bedrag van meer dan 250 euro die binnen de 14 dagen werden geleverd.
SELECT bestelnr 
FROM bestellingen 
WHERE bedrag > 250 
    AND DATEDIFF(leverdatum, besteldatum) < 14;

-- Toon de naam en de hoogte van de planten die tussen de 10 en de 50 cm of de 100 en 150 cm hoog zijn.
-- Naast de hoogte moet de tekst cm worden weergegeven.
SELECT naam, CONCAT(hoogte, ' cm') AS 'hoogtes' 
FROM planten  
WHERE hoogte BETWEEN 10 AND 50 OR hoogte BETWEEN 100 AND 150;

--  Toon de lijst van de woonplaatsen waar 2 of meer leveranciers wonen. Sorteer alfabetisch.
SELECT woonplaats, COUNT(*) AS Aantal 
FROM Leveranciers 
GROUP BY woonplaats 
HAVING COUNT(*) >= 2 
ORDER BY woonplaats;

-- Geef een overzicht (naam, soortnaam en hoogte) van alle waterplanten, gesorteerd op hoogte.
SELECT naam, soort, hoogte 
FROM planten JOIN soorten ON planten.soortID = soorten.soortID  
WHERE soort='water' 
ORDER BY hoogte;

-- Geef een overzicht van de planten gesorteerd op soort en vervolgens op naam die noch boom
-- noch heester zijn en waarvan de hoogte tussen de 100 en de 200 cm, de kleur rood of blauw is en de bloeiperiode begint voor augustus.
 SELECT * 
FROM planten  
    JOIN kleuren ON kleuren.kleurid = planten.kleurid 
    JOIN soorten ON planten.soortid  = soorten.soortid
WHERE (NOT soort IN ('boom', 'heester')) 
AND (hoogte BETWEEN 100 AND 200) AND (kleur IN ('rood', 'blauw')) AND (bl_b < 8) 
ORDER BY  soort, naam;

--  Geef per leverdatum in het formaat dd/mm/yyyy en per bestelbon de naam van de leverancier, het totaal aantal artikelen besteld,
--  en de som van het aantal maal de prijs per besteld artikel.
SELECT DATE_FORMAT(leverdatum, '%d/%m/%Y'), B.bestelnr, naam, SUM(aantal) AS 'totaal aantal', SUM(aantal*prijs) AS 'bedrag' 
FROM bestellingen B  
    JOIN leveranciers L ON B.levCode = L.levcode 
    JOIN bestellijnen BL ON B.bestelnr = BL.bestelnr 
GROUP BY leverdatum, B.bestelnr, naam;

-- Voeg als kleuren appelblauwzeegroen en zwart toe.
INSERT INTO kleuren(kleur) VALUES('appelblauwzeegroen');
INSERT INTO kleuren(kleur) VALUES ('zwart');

-- Voeg een spar toe aan de tabel planten. (artcode : 163, hoogte 3000, prijs : 12.5, soortID : 2, andere gegevens onbekend)
INSERT INTO planten(artcode, naam,hoogte,prijs, soortID) VALUES(163,'spar',3000,12.5,2);

-- Verhoog de prijs van alle planten met 5 procent
UPDATE planten SET prijs = prijs * 1.05;

--  Verwijder kleur blauw. Werkt dit?
DELETE FROM kleuren WHERE kleur = 'blauw';

-- Speler(Id, Naam, GeboorteJaar, Kleur, HuidigVak, IsAanDeBeurt, Spelnaam)
-- IR: Heeft als primaire sleutel een automatisch gegenereerde integer.
-- IR: De naam is maximum 100 karakters lang, is verplicht.
-- IR: Het geboortejaar is een integer.
-- IR: De kleur is een karakterwaarde van maximum 10 karakters. Maar enkel rood of zwart mag ingevoerd worden.
-- IR: Het huidigvak is een karakterwaarde van 20 lang en is niet verplicht.
-- IR: IsAanDeBeurt is een ja/neen veld.
-- IR: Spelnaam verwijst naar de verzameling Spel en is optioneel
CREATE TABLE Speler(
    Id INT AUTO_INCREMENT primary key,
    Naam VARCHAR(100) NOT NULL,
    GeboorteJaar INT,
    Kleur VARCHAR(10),
    Huidigvak VARCHAR(20),
    IsAanDeBeurt BOOLEAN,
    Spelnaam VARCHAR(20) references spel(naam),
    -- CONSTRAINT FK_Speler_Spel FOREIGN KEY(Spelnaam) REFERENCES Spel(Naam),
    CONSTRAINT kleur_constraint CHECK (Kleur IN ('rood','zwart'))
    ); 





    

    
