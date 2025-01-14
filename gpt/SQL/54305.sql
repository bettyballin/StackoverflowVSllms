SELECT AVG(word_count) AS avg_words_per_document\nFROM (\n    SELECT\n        content,\n        LENGTH(content) - LENGTH(REPLACE(content, ' ', '')) + 1 AS word_count\n    FROM documents\n) AS word_counts;