SELECT COUNT(*) AS monthApplicationEntered\nFROM tblEventDates\nWHERE MONTH(evdtApplication) = MONTH(GETDATE())\n  AND YEAR(evdtApplication) = YEAR(GETDATE());