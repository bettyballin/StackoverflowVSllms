SELECT Code\nINTO #TempTable\nFROM YourTable\nGROUP BY Code\nHAVING SUM(CASE WHEN Status <> 'A' THEN 1 ELSE 0 END) = 0