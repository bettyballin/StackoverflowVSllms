SELECT\n    t.entry_id,\n    COUNT(t.token) * X AS points, -- Replace X with the point value for each token match\n    MAX(e.date) AS latest_date -- Assuming there is a date column in the entries table\nFROM\n    tokens t\nJOIN\n    entries e ON t.entry_id = e.id\nWHERE\n    t.token IN ('see', 'spot', 'run') -- Replace with the user-provided tokens\nGROUP BY\n    t.entry_id\nORDER BY\n    points DESC,\n    latest_date DESC; -- Sort by points first, then by date if points are equal