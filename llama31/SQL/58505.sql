WITH RECURSIVE tag_subsets AS (\n  -- same as above\n)\nSELECT ts.level, p.post_id, p.title, p.text\nFROM tag_subsets ts\nJOIN Post_tag_nn pt ON ts.tag_id = pt.tag_id\nJOIN Posts p ON pt.post_id = p.post_id\nGROUP BY ts.level, p.post_id, p.title, p.text\nORDER BY ts.level DESC;