SELECT pe.prodtree_element_name_l, \n       (SELECT TOP 1 rs.resource_value \n        FROM resource_shortstrings rs \n        WHERE rs.resource_key = pe.prodtree_element_name_l_rk \n          AND rs.language_id = '5') AS resource_value\nFROM prodtree_element pe\nWHERE pe.prodtree_element_name_l <> ''