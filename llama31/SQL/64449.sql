SELECT COUNT(1)\nFROM records r\nJOIN addresses a USING (address_id)\nJOIN rates p USING (rate_id)\nWHERE r.status = 1\n  AND p.code = 1\n  AND a.state = 'TN';