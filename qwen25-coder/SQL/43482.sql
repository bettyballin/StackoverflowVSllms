SELECT \n    entry.*, \n    location.*\nFROM \n    entry\nINNER JOIN \n    entry_locations ON entry.id = entry_locations.entry_id\nINNER JOIN \n    location ON entry_locations.location = location.name_or_code\nWHERE \n    entry_locations.location = 'France';