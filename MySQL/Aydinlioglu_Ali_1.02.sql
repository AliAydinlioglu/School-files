-- vraag1
select titles.primaryTitle, persons.fullName
from titles, persons, actors, genres
where titles.tconst = genres.tconst 
and titles.tconst = actors.tconst
and persons.nmconst = actors.nmconst
and genres.genre like "comedy" and titles.titleType like 'tvSeries'and  titles.runtimeMinutes between 25 and 60
order by fullName;

-- vraag2
select titles.titleType, count(ratings.numVotes) as TotaalAantalStemmen
from titles, ratings;

-- vraag3
select startYear, count(titles.titleType) as AantalFilms
from directors, titles
where titles.titleType like 'movie' and count(titles.titleType) > 100
order by titles.titleType desc;

-- vraag4
select titles.primaryTitle, titles.tconst
from titles, directors
where titles.tconst = directors.tconst
and titles.primaryTitle like '%four%' and directors is null;

-- vraag5
select titles.primaryTitle, ratings.averageRating,
case
when averageRating > 8 
	then 'Uitstekend'
when averageRating between 6 and 8 
	then 'Goed'
		else 'Minder goed'
end as 'BeoordelingsCategorie'
from titles, ratings;

-- vraag6
create table Filmmuziek(
	SoundtrackID  INT AUTO_INCREMENT primary key,
    Titel varchar(50),
    Componist varchar(50)
);
INSERT INTO Filmmuziek(Titel,Componist) VALUES('The Dark Knight Theme', 'Hans Zimmer');
INSERT INTO Filmmuziek(Titel,Componist) VALUES('Once Upon a Time in the West Theme', 'Ennio Morricone');
select SoundtrackID,Titel,Componist
from Filmmuziek;