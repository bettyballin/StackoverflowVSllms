INSERT INTO NextKeyValue(KeyName, KeyValue) \nSELECT 'DisplayWorkItemId' AS KeyName, \n       (COALESCE(MAX(work_item_display_id), 0) + 1) AS KeyValue \nFROM work_item;