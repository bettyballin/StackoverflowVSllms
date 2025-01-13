SELECT topics.id\nFROM topics\n  INNER JOIN topic_tags topic_ptags\n    ON topics.id = topic_ptags.topicFk\n  INNER JOIN tags ptags\n    ON topic_ptags.tagFk = ptags.id\n      AND ptags.name IN ('a','b','c')\n  LEFT JOIN topic_tags topic_ntags\n    ON topics.id = topic_ntags.topicFk\n  LEFT JOIN tags ntags\n    ON topic_ntags.tagFk = ntags.id\n      AND ntags.name IN ('d','e','f')\nGROUP BY topics.id\nHAVING count(DISTINCT ptags.id) = 3\n  AND count(ntags.id) = 0