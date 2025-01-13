SELECT t2.word_fragment\nFROM table2 t2\nWHERE t2.word_fragment <= (\n    SELECT t1.word\n    FROM table1 t1\n    WHERE t1.word = 'gumby'\n)\nORDER BY t2.word_fragment DESC\nLIMIT 1;