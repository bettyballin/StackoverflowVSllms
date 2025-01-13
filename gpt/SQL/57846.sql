SELECT COUNT(*) AS total_rows\n   FROM posts p\n   JOIN postimages pi ON pi.post_id = p.id\n   JOIN images im ON pi.image_id = im.image_id\n   WHERE im.active = 1;