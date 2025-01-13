WITH RECURSIVE related_words AS (\n  SELECT w.word, 0 AS hop\n  FROM words w\n  WHERE w.word = 'security'\n  UNION ALL\n  SELECT w2.word, hop + 1\n  FROM related_words rw\n  JOIN relations r ON rw.word = r.synset1_id\n  JOIN synsets s ON r.synset2_id = s.synset_id\n  JOIN words w2 ON s.synset_id = w2.synset_id\n  WHERE hop < 2\n)\nSELECT DISTINCT word FROM related_words;