-- First, try to insert the album if it doesn't exist, ignore any duplicate key error.\nINSERT IGNORE INTO albums (album_date) VALUES (CURDATE());\n\n-- Then select the correct album ID.\nSELECT album_id FROM albums WHERE album_date = CURDATE();