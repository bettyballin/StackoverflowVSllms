REPLACE INTO entity (entity_id, group_id, last_seen) \nSELECT entity_id, group_id, record_date \nFROM entity_raw \nWHERE record_date = CURDATE() - INTERVAL 1 DAY;