CREATE VIEW property_owners_view AS\n   SELECT o.owner_id,\n          o.first_name || ' ' || o.last_name || ' ' || a.address || ' ' || p.property_details AS combined_text\n     FROM owners o\n     JOIN addresses a ON o.owner_id = a.owner_id\n     JOIN properties p ON o.owner_id = p.owner_id;