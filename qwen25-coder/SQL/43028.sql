SELECT p.id, p.name,\n       GROUP_CONCAT(s.name SEPARATOR ',') AS site_list\nFROM publications p\nJOIN sites s ON s.id = p.site_id\nGROUP BY p.id, p.name;