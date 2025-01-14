SELECT p2.id, p2.title, COUNT(ptt1.tag_id) AS common_tag_count\nFROM Posts p1\nJOIN posts_to_tags_joining_table ptt1 ON p1.id = ptt1.post_id\nJOIN posts_to_tags_joining_table ptt2 ON ptt1.tag_id = ptt2.tag_id\nJOIN Posts p2 ON ptt2.post_id = p2.id\nWHERE p1.id = ? AND p2.id != p1.id\nGROUP BY p2.id, p2.title\nORDER BY common_tag_count DESC;