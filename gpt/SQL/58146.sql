DECLARE @Keywords KeywordTableType;\n\n-- Split the input string and insert into the table variable\nINSERT INTO @Keywords (Keyword)\nSELECT value FROM STRING_SPLIT('Oakland;City;Planning', ';');\n\n-- Execute the stored procedure\nEXEC FilterProjects @Keywords;