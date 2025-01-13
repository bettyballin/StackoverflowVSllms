-- Find assets with the same attributes as Asset-A\nWITH asset_a_attributes AS (\n  SELECT AttributeId\n  FROM Table2\n  WHERE AssetId = 'Asset-A'\n)\nSELECT DISTINCT t2.AssetId\nFROM Table2 t2\nJOIN asset_a_attributes a ON t2.AttributeId = a.AttributeId\nWHERE t2.AssetId != 'Asset-A'\nGROUP BY t2.AssetId\nHAVING COUNT(DISTINCT t2.AttributeId) = (SELECT COUNT(*) FROM asset_a_attributes);\n\n-- Find common attributes between Asset-A and Asset-B\nWITH asset_a_attributes AS (\n  SELECT AttributeId\n  FROM Table2\n  WHERE AssetId = 'Asset-A'\n),\nasset_b_attributes AS (\n  SELECT AttributeId\n  FROM Table2\n  WHERE AssetId = 'Asset-B'\n)\nSELECT a.AttributeId\nFROM asset_a_attributes a\nINTERSECT\nSELECT b.AttributeId\nFROM asset_b_attributes b;