SELECT * \nFROM bb_topics \nWHERE topic_poster = 5 \n  AND topic_id IN (\n    (SELECT MAX(topic_id) FROM bb_topics WHERE topic_poster = 5 AND topic_id < 123),\n    (SELECT MIN(topic_id) FROM bb_topics WHERE topic_poster = 5 AND topic_id > 123)\n  )