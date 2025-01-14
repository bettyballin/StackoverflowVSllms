-- Find who owned car Y at time X\nSELECT o.owner_id, o.name, oh.car_id, c.make, c.model\nFROM Owners o\nJOIN OwnershipHistory oh ON o.owner_id = oh.owner_id\nJOIN Cars c ON c.car_id = oh.car_id\nWHERE oh.car_id = Y\nAND oh.start_date <= 'X'\nORDER BY oh.start_date DESC\nLIMIT 1;\n\n-- Find which cars owner Z owned at time X\nSELECT c.car_id, c.make, c.model, oh.start_date\nFROM Cars c\nJOIN OwnershipHistory oh ON c.car_id = oh.car_id\nJOIN Owners o ON o.owner_id = oh.owner_id\nWHERE o.owner_id = Z\nAND oh.start_date <= 'X'\nGROUP BY c.car_id, c.make, c.model, oh.start_date;