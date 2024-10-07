-- Vraag1
SELECT primaryTitle, fullName 
from titles, persons, actors, genres
where titles.tconst = genres.tconst
and titles.tconst = actors.tconst
and actors.nmconst  = persons.nmconst
and genres.genre = "Drama" and startYear between 2010 and 2014
order by primaryTitle desc;

-- Vraag 2
select averageratings, count(titleType) 
from titles
JOIN ratings r ON t.tconst = r.tconst
order by averageratings;

-- Vraag 3
select nmconst, fullname, count(titles) as geregiseerde_films
from directors
join titles on titles.tconst = directors.nmconst
where count(titles) > 3
order by directors.fullname;

-- Vraag 4
select primaryTitle, writers.tconst
from titles
join writers on writers.tconst = titles.tconst
where primaryTitle = '%wall';

-- Vraag 5
select titles.primaryTitle, titles.runtimeMinutes as Duurtijd,
case
when runtimeMinutes < 90 
	then 'Kort'
when runtimeMinutes between 90 and 150
	then 'Gemiddeld'
		else 'Lang'
end as 'duur'
from titles;
    
	
-- Vraag 6
CREATE TABLE Filmlocaties(
    LocatieId INT AUTO_INCREMENT primary key,
    Naam VARCHAR(50) NOT NULL, 
    Stad VARCHAR(50),
    Land VARCHAR(50),
	beschrijving text
    ); 
    
    INSERT INTO Filmlocaties(Naam, Stad,Land,beschrijving) VALUES('Times Square','New York City','Verenigde Staten','Beroemd plein Manhatten');
	INSERT INTO Filmlocaties(Naam, Stad,Land,beschrijving) VALUES('Trevi-fontein','Rome','Italie','Beroemd fontein in Rome');
    select Naam, Stad,Land,beschrijving
    from Filmlocaties





