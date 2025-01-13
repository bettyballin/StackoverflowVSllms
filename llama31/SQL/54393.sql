WITH ranked AS (\n  SELECT \n    indicator_id, \n    alternative_id, \n    analysis_id, \n    rank, \n    ROW_NUMBER() OVER (PARTITION BY indicator_id, alternative_id ORDER BY analysis_id) AS row_num\n  FROM \n    rankings\n  WHERE \n    analysis_id IN (@analysisId1, @analysisId2, ...)  -- list of analysis IDs to compare\n)\nSELECT \n  r1.indicator_id, \n  r1.alternative_id, \n  r1.analysis_id, \n  r1.rank\nFROM \n  ranked r1\n  JOIN ranked r2 ON r1.indicator_id = r2.indicator_id AND r1.alternative_id = r2.alternative_id AND r1.row_num < r2.row_num\nWHERE \n  r1.rank != r2.rank