$redis = new Redis();\n$redis->connect('localhost', 6379);\n\n$tags = $redis->get('tags');\nif (!$tags) {\n    $tags = array();\n    foreach ($database->query("SELECT tag_name, COUNT(tag_id) AS 'tag_count' FROM tags LEFT OUTER JOIN videotags ON tags.id=videotags.tag_id GROUP BY tags.id ORDER BY tag_count DESC") as $tag) {\n        $tags[] = $tag["tag_name"];\n    }\n    $redis->set('tags', serialize($tags));\n    $redis->expire('tags', 86400); // cache for 1 day\n}\n\necho implode(', ', $tags);