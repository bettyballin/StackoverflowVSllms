SELECT ne1.name, ne1.email\nFROM name_email ne1\nLEFT JOIN name_email ne2 ON ne1.name = ne2.name AND ne2.email LIKE '%@yahoo.com'\nWHERE ne2.name IS NULL OR ne1.email NOT LIKE '%@yahoo.com';