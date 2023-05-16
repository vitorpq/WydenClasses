select Name as 'Nome Artista', Title as 'Nome Album'
from Artist, Album 
where Artist.ArtistId == Album.ArtistId and Artist.Name = 'AC/DC';