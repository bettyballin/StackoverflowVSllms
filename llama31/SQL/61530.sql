CREATE TRIGGER update_presentations\nON Presentations\nAFTER UPDATE\nAS\nBEGIN\n    IF trigger_nestlevel() < 2\n        UPDATE Events\n        SET Events.Date = Presentations.Date,\n            Events.Location = Presentations.Location\n        FROM Presentations INNER JOIN Events ON Presentations.EventID = Events.ID\n        WHERE Presentations.ID IN (SELECT ID FROM inserted)\nEND\n\nCREATE TRIGGER update_events\nON Events\nAFTER UPDATE\nAS\nBEGIN\n    IF trigger_nestlevel() < 2\n        UPDATE Presentations\n        SET Presentations.Date = Events.Date,\n            Presentations.Location = Events.Location\n        FROM Events INNER JOIN Presentations ON Events.PresentationID = Presentations.ID\n        WHERE Events.ID IN (SELECT ID FROM inserted)\nEND