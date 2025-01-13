SELECT DISTINCT \n  b.ip_address \nFROM \n  code_table a, \n  location b \nWHERE \n  a.code_item = b.which_id \n  AND TRIM(a.location_type_code) = '15' \n  AND TRIM(a.code_status) = 'R'