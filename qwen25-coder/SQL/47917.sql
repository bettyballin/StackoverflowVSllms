SELECT DISTINCT i.Id\n    FROM Item i\n    WHERE EXISTS (\n        SELECT 1\n        FROM Event e\n        WHERE e.Id = i.EventId AND e.Home_team IN (1,2,3,4,5)\n    )\n    AND EXISTS (\n        SELECT 1\n        FROM Seat s\n        WHERE s.VenueId = e.VenueId AND s.Configuration = e.Configuration AND s.Section = i.Section AND s.exclude = 0\n    );