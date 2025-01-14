SELECT ads.*, location.county \nFROM ads\nLEFT JOIN location ON location.county = ads.county_id\nWHERE ads.published = 1 \nAND ads.type = 13\nAND ads.county_id IN (2, 5, 7, 9);