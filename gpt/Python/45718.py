query = Album.query(Album.genre == 'Rock').order(Album.publication_year)\nalbums = query.fetch()