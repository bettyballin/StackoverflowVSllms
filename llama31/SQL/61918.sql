SELECT \n    r.*,\n    CASE \n        WHEN a.record_id IS NULL THEN 0 \n        ELSE 1 \n    END AS HasChanges,\n    a.change_date AS LastChangeDate\nFROM \n    records r\nLEFT JOIN \n    (SELECT \n         record_id, \n         MAX(change_date) AS change_date \n     FROM \n         audit_trail \n     WHERE \n         operation = 'UPDATE' \n     GROUP BY \n         record_id) a ON r.id = a.record_id\nWHERE \n    r.id = @recordId;