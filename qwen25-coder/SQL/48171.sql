SELECT c.*\nFROM Call c\nLEFT JOIN Phone_book p ON c.phone_number = p.phone_number\nWHERE p.id IS NULL;