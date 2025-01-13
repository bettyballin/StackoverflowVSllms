SELECT DOCUMENT_ID\nFROM your_table\nWHERE TAG IN ('tag1', 'tag2')\nGROUP BY DOCUMENT_ID\nHAVING COUNT(DISTINCT TAG) = 2