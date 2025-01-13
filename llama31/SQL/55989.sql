SELECT p.id, p.name, ph.id AS photo_id, ph.path, ph.title\nFROM persons p\nLEFT JOIN photos ph ON p.id = ph.person_id\nORDER BY ph.title;