WITH cte_special_mat AS (\n    SELECT content_id,\n           max(file_location) keep (dense_rank first order by resolution desc) as special_mat_file_location,\n           max(file_size) keep (dense_rank first order by resolution desc) as special_mat_file_size\n    FROM mat\n    /* Add your additional criteria here */\n    GROUP BY content_id\n)\nSELECT m.material_id,\n       m.content_id,\n       c.special_mat_file_location,\n       c.special_mat_file_size\nFROM mat m\nJOIN cte_special_mat c ON m.content_id = c.content_id\nWHERE m.material_id IN (\n    SELECT material_id\n    FROM mat\n    INNER JOIN con ON con.content_id = mat.content_id\n    INNER JOIN con_groups ON con_groups.content_id = con.content_id\n    WHERE con_groups.content_group_id = 10\n);