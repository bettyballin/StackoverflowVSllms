INSERT INTO map (mapId, itemId, catId)\nSELECT CONCAT(?, '|', catId), ?, catId\nFROM categories\nWHERE catName IN ('each', 'category', 'name');