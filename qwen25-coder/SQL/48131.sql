UPDATE table_name \n   SET field_name = REPLACE(\n       REPLACE(field_name, 'search_text1', 'replace_text1'),\n       'search_text2', 'replace_text2'\n   );