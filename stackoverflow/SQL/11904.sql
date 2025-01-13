SELECT posts.id, posts.title, posts.content\nFROM posts \nWHERE NOT EXISTS (\n  SELECT post_id from tags\n  WHERE tags.tag LIKE '%$keywords%' \n    AND posts.id=tags.post_id\n)