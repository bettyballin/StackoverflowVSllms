SELECT \n  c.cat_id, \n  c.cat_name, \n  COUNT(DISTINCT d.dom_id) AS domain_count\nFROM \n  categories c\n  INNER JOIN domains d ON c.cat_id = d.dom_catid\n  INNER JOIN (\n    SELECT DISTINCT \n      r.rev_domain_from \n    FROM \n      reviews r \n    WHERE \n      r.rev_status = 1\n  ) AS subquery ON d.dom_id = subquery.rev_domain_from\nGROUP BY \n  c.cat_name\nORDER BY \n  c.cat_name;