SELECT document.*, Score(1) as total_score\nFROM document\nWHERE CONTAINS(document, \n               'documentContent:the_keyword weight 1 OR documentTitle:the_keyword weight 2', 1) > 0\nORDER BY total_score DESC;