SELECT \n  mov_id,\n  mov_title,\n  GROUP_CONCAT(categories.cat_name SEPARATOR ',') as all_genres,\n  GROUP_CONCAT(cat_id SEPARATOR ',') as all_genres_ids,\n  -- ...\nFROM movies\n  JOIN _genres ON movies.mov_id = _genres.gen_movieid\n  JOIN categories ON _genres.gen_catid = categories.cat_id\n  -- ...\nWHERE mov_id = *MOVIE_ID* AND mov_status = 1\nGROUP BY mov_id