$sql .= "SELECT SQL_CALC_FOUND_ROWS * FROM \n         posts p, images im, postimages pi \n         WHERE i.active = 1 \n         AND pi.post_id = p.id\n         AND pi.image_id = im.image_id \n         ORDER BY created_at LIMIT 16";\n\n// execute the query\n\n$sql_count = "SELECT FOUND_ROWS()";\n$count_result = mysql_query($sql_count);\n$total_rows = mysql_result($count_result, 0);