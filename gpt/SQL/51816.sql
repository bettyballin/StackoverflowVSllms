WITH UniqueBaseValues AS (\n    SELECT DISTINCT pe.prodtree_element_name_l, pe.prodtree_element_name_l_rk\n    FROM prodtree_element pe\n)\n\nSELECT ubv.prodtree_element_name_l, rs.resource_value, ubv.prodtree_element_name_l_rk\nFROM UniqueBaseValues ubv\nLEFT JOIN resource_shortstrings rs\n    ON ubv.prodtree_element_name_l_rk = rs.resource_key\nWHERE rs.language_id = '5'\nORDER BY ubv.prodtree_element_name_l;