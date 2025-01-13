SELECT \n  g.*,\n  v.score,\n  p.pictures\nFROM \n  gallery g\n  LEFT JOIN (\n    SELECT vote_gallery_ref, SUM(vote_value) as score\n    FROM vote\n    GROUP BY vote_gallery_ref\n  ) v ON g.gallery_id = v.vote_gallery_ref\n  LEFT JOIN (\n    SELECT picture_gallery_ref, COUNT(picture_id) AS pictures\n    FROM picture\n    GROUP BY picture_gallery_ref\n  ) p ON g.gallery_id = p.picture_gallery_ref