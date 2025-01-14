SELECT p.id, p.name, \n       (SELECT GROUP_CONCAT(s.name SEPARATOR ', ')\n          FROM sites s \n         WHERE s.id = p.site_id) AS site_list\n  FROM publications p;