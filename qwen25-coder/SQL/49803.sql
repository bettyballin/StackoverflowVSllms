WITH RankedValues AS (\n    SELECT value, attribute_definition_id, value_rk,\n           ROW_NUMBER() OVER (PARTITION BY value ORDER BY value_rk DESC) as rk_rank\n    FROM attribute_values\n)\nSELECT value, attribute_definition_id, value_rk\nFROM RankedValues\nWHERE rk_rank = 1;