SELECT SUM(r.distance) AS total_distance\nFROM event e\nJOIN route r ON e.destination = r.name\nWHERE e.executed = 1\nAND e.drivers LIKE CONCAT('%', 'jill', '%');