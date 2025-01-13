SELECT fm.file_id, COALESCE(d.value, fm.value) AS value\nFROM file_metrics fm\nLEFT JOIN deltas d ON fm.id = d.file_id AND d.revision_id = ?\nWHERE fm.id IN (SELECT file_id FROM deltas WHERE revision_id = ?)