$mycid = db_fetch_object(db_query('SELECT * FROM {comments} WHERE nid = %d ORDER BY RAND() LIMIT 1', $mynid));\nreturn theme_comment_view($mycid,$mynid);