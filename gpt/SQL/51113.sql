EXPLAIN SELECT\n   *\n   FROM\n   content_link link USE INDEX (content_id)\n   STRAIGHT_JOIN\n   content\n   ON\n   link.content_id = content.id\n   LIMIT 10;