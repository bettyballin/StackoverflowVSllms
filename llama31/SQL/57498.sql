SELECT DISTINCT a.name, a.location_id, a.application_id \nFROM apps a \nJOIN locations l ON a.location_id = l.location_id \nJOIN applications ap ON a.application_id = ap.application_id \nWHERE /*condition*/