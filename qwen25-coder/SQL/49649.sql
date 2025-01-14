SELECT document.*, Score(1) as total_score\nFROM document\nWHERE CONTAINS(documentContent || ' ' || documentTitle, \n               '(the_keyword within documentContent weight 1) OR (the_keyword within documentTitle weight 2)', 1) > 0\nORDER BY total_score DESC;