SELECT e.EntityID, e.EntityType, v.VoteCount\nFROM Entities e\nJOIN (\n    SELECT EntityID, COUNT(*) AS VoteCount\n    FROM Votes\n    GROUP BY EntityID\n) AS v ON e.EntityID = v.EntityID\nORDER BY v.VoteCount DESC;