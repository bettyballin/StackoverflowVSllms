SELECT id, band_name, song_name, album_name, genre \nFROM us_music \nWHERE genre = 'punk'\nUNION \nSELECT id, band_name, song_name, album_name, genre \nFROM de_music \nWHERE genre = 'punk'\nUNION\nSELECT id, band_name, song_name, album_name, genre \nFROM fr_music \nWHERE genre = 'punk'\nORDER BY <user_defined_column>;