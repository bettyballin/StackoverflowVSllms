SELECT 'A' AS Source, ColumnA AS ColumnValue FROM TableA\nUNION ALL\nSELECT 'B' AS Source, ColumnB AS ColumnValue FROM TableB\nUNION ALL\nSELECT 'C' AS Source, ColumnC AS ColumnValue FROM TableC;