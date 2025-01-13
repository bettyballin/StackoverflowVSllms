SELECT \n  ti.itemId, \n  ti.title, \n  tis.statusKey, \n  tis.statusDate\nFROM \n  todo_item ti\n  JOIN todo_project tp ON ti.projectId = tp.projectId\n  JOIN todo_itemStatus tis ON ti.itemId = tis.itemId\nWHERE \n  tp.projectId = 13\n  AND tis.statusDate = (\n    SELECT MAX(statusDate)\n    FROM todo_itemStatus\n    WHERE itemId = ti.itemId\n  )