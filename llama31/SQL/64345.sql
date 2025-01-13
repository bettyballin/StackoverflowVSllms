INSERT INTO entity (entity_id, group_id, first_seen, last_seen)\nSELECT entity_id, group_id, record_date, record_date\nFROM entity_raw\nWHERE (record_date = DATE(DATE_SUB(NOW(),INTERVAL 1 DAY)))\nON DUPLICATE KEY UPDATE last_seen = VALUES(last_seen)