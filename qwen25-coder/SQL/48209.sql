WITH NumberedLogs AS (\n  SELECT LogEntry, ID,\n         ROW_NUMBER() OVER (ORDER BY ID) - \n         ROW_NUMBER() OVER (PARTITION BY LogEntry ORDER BY ID) AS sequence_id\n  FROM LogEntries\n),\nSequencedLogs AS (\n  SELECT LogEntry, COUNT(*) AS EntryCount\n  FROM NumberedLogs\n  GROUP BY LogEntry, sequence_id\n)\nSELECT LogEntry, EntryCount\nFROM SequencedLogs\nORDER BY LogEntry, sequence_id;