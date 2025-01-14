WITH dog_counts AS (\n    SELECT owner, COUNT(*) AS num_dogs\n    FROM dogs\n    GROUP BY owner\n),\ncat_counts AS (\n    SELECT owner, COUNT(*) AS num_cats\n    FROM cats\n    GROUP BY owner\n)\nSELECT \n    COALESCE(dog_counts.owner, cat_counts.owner) AS owner,\n    COALESCE(num_dogs, 0) AS num_dogs,\n    COALESCE(num_cats, 0) AS num_cats\nFROM dog_counts\nFULL OUTER JOIN cat_counts\nON dog_counts.owner = cat_counts.owner\nORDER BY owner;