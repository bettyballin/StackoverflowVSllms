INSERT INTO company_id_sequence (company_id, next_internal_id) \nSELECT ID, 1 \nFROM Company;