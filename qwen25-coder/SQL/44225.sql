WITH col2_col1_mapping AS (\n    SELECT \n        col2, \n        STRING_AGG(DISTINCT col1, ',') AS distinct_col1_values\n    FROM \n        your_table_name\n    GROUP BY \n        col2\n)\n\nSELECT \n    col2, \n    distinct_col1_values\nFROM \n    col2_col1_mapping\nWHERE \n    LENGTH(distinct_col1_values) - LENGTH(REPLACE(distinct_col1_values, ',', '')) > 0;