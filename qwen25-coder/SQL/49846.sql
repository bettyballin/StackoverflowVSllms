-- Fetch rows where 1 is present in any column\nSELECT 'id1' AS column_name, id2, id3, id4, other_field \nFROM your_table_name WHERE id1 = 1\n\nUNION ALL \n\nSELECT 'id2' AS column_name, id1, id3, id4, other_field \nFROM your_table_name WHERE id2 = 1\n\nUNION ALL \n\nSELECT 'id3' AS column_name, id1, id2, id4, other_field \nFROM your_table_name WHERE id3 = 1\n\nUNION ALL \n\nSELECT 'id4' AS column_name, id1, id2, id3, other_field \nFROM your_table_name WHERE id4 = 1;