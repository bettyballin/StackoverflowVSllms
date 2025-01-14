SELECT c.name AS name, NULL AS sc_name, NULL AS ssc_name\nFROM categories c\n\nUNION ALL\n\nSELECT c.name AS name, sc.name AS sc_name, NULL AS ssc_name\nFROM categories c\nLEFT JOIN subcategories sc ON c.id = sc.category_id\nWHERE sc.id IS NOT NULL\n\nUNION ALL\n\nSELECT c.name AS name, sc.name AS sc_name, ssc.name AS ssc_name\nFROM categories c\nJOIN subcategories sc ON c.id = sc.category_id\nJOIN subsubcategories ssc ON sc.id = ssc.subcategory_id;