SELECT \n    CONVERT(INT, SUBSTRING(comment_field, CHARINDEX('id ', comment_field) + 3, LEN(comment_field))) AS extracted_id\nFROM \n    your_table_name;