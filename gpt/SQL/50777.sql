-- Insert new rows from #TableB that do not exist in TableA\nINSERT INTO TableA (columns)\nSELECT columns\nFROM #TableB\nWHERE NOT EXISTS (SELECT 1 FROM TableA WHERE TableA.id = #TableB.id);