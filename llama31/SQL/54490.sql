SELECT \n    e.eventId, \n    e.eventName, \n    (\n        SELECT STRING_AGG(ea.artistName, ', ')\n        FROM event_artist ea\n        WHERE ea.eventId = e.eventId\n    ) AS ArtistLineup\nFROM \n    event e