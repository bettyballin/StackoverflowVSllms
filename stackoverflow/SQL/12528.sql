SELECT DISTINCT page_title FROM a\nWHERE page_title NOT IN (SELECT page_title FROM b)