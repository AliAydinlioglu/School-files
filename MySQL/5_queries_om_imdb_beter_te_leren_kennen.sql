-- 1. Geef de unieke lijst van genres. Sorteer alfabetisch. (27 recrords)
SELECT DISTINCT genre FROM genres
ORDER BY genre;

-- 2. Welke verschillende titleType's zijn er opgenomen in titles. Sorteer alfabetisch. (4 records)
SELECT DISTINCT titleType
FROM titles
ORDER BY titleType ASC;

-- 3. Geef een overzicht van de primaryTitle van alle films met hun rating. 
-- Sorteer aflopend op rating en vervolgens aflopend op numVotes

-- primaryTitle, averageRating, numVotes
-- The Shawshank Redemption, 9.30, 2658388
-- The Godfather, 9.20, 1842392
-- The Chaos Class, 9.20, 40839
-- Kantara, 9.10, 62530
-- The Dark Knight, 9.00, 2631209
SELECT t.primaryTitle, r.averageRating, r.numVotes
FROM titles t JOIN ratings r ON t.tconst = r.tconst
WHERE t.titleType = 'movie'
ORDER BY r.averageRating DESC, r.numVotes DESC;


-- 4. Welke tvSeries hebben 10 of meer seizoenen?

-- tconst, primaryTitle, numberOfSeasons
-- tt0096697, The Simpsons, 34
-- tt1628033, Top Gear, 33
-- tt0121955, South Park, 25
-- tt0380136, QI, 20
-- tt0472954, It's Always Sunny in Philadelphia, 15
-- tt0436992, Doctor Who, 14
SELECT t.tconst, t.primaryTitle, MAX(e.seasonNumber) As numberOfSeasons
FROM titles t JOIN episodes e ON t.tconst = e.parentTconst
WHERE t.titleType = 'tvSeries'
GROUP BY t.tconst, t.primaryTitle
HAVING MAX(e.seasonNumber) >= 10
ORDER BY 3 DESC;

-- 5. Geef een overzicht van het aantal films per acteur. Sorteer aflopend op aantal films.

-- nmconst, fullName, numberOfMovies
-- nm0000134, Robert De Niro, 50
-- nm0000115, Nicolas Cage, 41
-- nm0000168, Samuel L. Jackson, 40
-- nm0000158, Tom Hanks, 40
-- nm0000246, Bruce Willis, 37
SELECT p.nmconst, p.fullName, COUNT(t.tconst) As numberOfMovies
FROM persons p JOIN actors a ON p.nmconst = a.nmconst
JOIN titles t ON a.tconst = t.tconst
WHERE t.titleType = 'movie'
GROUP BY p.nmconst, p.fullName
ORDER BY 3 DESC