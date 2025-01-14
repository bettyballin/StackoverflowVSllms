SELECT m.title, a.name AS lead_actor\nFROM movie m\nJOIN casting c ON m.id = c.movieid\nJOIN actor a ON c.actorid = a.id\nWHERE c.ord = 1\nAND m.id IN (\n    SELECT c2.movieid\n    FROM casting c2\n    JOIN actor a2 ON c2.actorid = a2.id\n    WHERE a2.name = 'Julie Andrews'\n);