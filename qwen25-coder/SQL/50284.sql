SELECT \n    document_id,\n    tag_id,\n    size,\n    @cumulative_size := @cumulative_size + size AS cumulative_size\nFROM \n    documents, \n    (SELECT @cumulative_size := 0) var_init_subquery\nWHERE \n    tag_id = 26 AND \n    (@cumulative_size < 600)\nORDER BY \n    document_id;  -- or by any other field that represents the desired order