SELECT d.id, d.size, d.date_created\nFROM documents d\nINNER JOIN documents d2 ON d2.tag_id=d.tag_id AND d2.date_created >= d.date_created\nWHERE d.tag_id=26\nGROUP BY d.id, d.size, d.date_created\nHAVING sum(d2.size) <= 600\nORDER BY d.date_created DESC