CREATE INDEX idx_movies_mov_id ON movies(mov_id);\n    CREATE INDEX idx_genres_gen_movieid ON _genres(gen_movieid);\n    -- Add similar indexes for other relevant columns.