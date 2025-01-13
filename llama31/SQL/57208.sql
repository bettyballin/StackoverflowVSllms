SELECT t.*\nFROM topics t\nJOIN (\n  SELECT tt.topic_id\n  FROM tags_topics tt\n  WHERE tt.tag_id IN (1, 2, 3)\n  GROUP BY tt.topic_id\n  HAVING COUNT(DISTINCT tt.tag_id) = 3\n) AS filtered_topics\nON t.id = filtered_topics.topic_id;