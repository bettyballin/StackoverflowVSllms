SELECT \n  categories.catName,\n  COUNT(map.itemId) AS item_count,\n  SUM(CASE WHEN items.ownerId = @ownerId THEN 1 ELSE 0 END) AS owner_item_count\nFROM categories\nLEFT JOIN map ON categories.catId = map.catId\nLEFT JOIN items ON items.itemId = map.itemId\nGROUP BY categories.catName, categories.catId\nHAVING item_count <> 0 OR owner_item_count <> 0;