SELECT c.cat_id, c.cat_name, COUNT(DISTINCT d.dom_id) AS domain_count\nFROM categories c\nJOIN (\n    SELECT DISTINCT r.rev_domain_from AS dom_id\n    FROM reviews r\n    WHERE r.rev_status = 1\n) r ON c.cat_id = d.dom_catid\nGROUP BY c.cat_id, c.cat_name\nORDER BY c.cat_name;