CREATE TRIGGER UpdateDateChanged\nON Table1\nAFTER UPDATE\nAS\nBEGIN\n    UPDATE Table1\n    SET DateChanged = GETDATE()\n    FROM Table1 INNER JOIN inserted ON Table1.Id = inserted.Id\nEND