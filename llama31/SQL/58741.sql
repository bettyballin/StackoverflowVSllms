SELECT t.*\nFROM topics t\nJOIN topic_tags tt ON t.id = tt.topicFk\nJOIN tags tg ON tt.tagFk = tg.id\nWHERE tg.name IN ('a', 'b', 'c')\nGROUP BY t.id\nHAVING COUNT(DISTINCT tg.name) = 3\nAND NOT EXISTS (\n  SELECT 1\n  FROM topic_tags tt2\n  JOIN tags tg2 ON tt2.tagFk = tg2.id\n  WHERE tt2.topicFk = t.id AND tg2.name IN ('d', 'e', 'f')\n);