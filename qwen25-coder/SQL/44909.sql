SELECT \n    COUNT(DISTINCT a.itemID) AS CommonVotes,\n    SUM(CASE WHEN a.direction = b.direction THEN 1 ELSE 0 END) AS SameDirectionVotes\nFROM \n    votes a\nJOIN \n    votes b ON a.itemID = b.itemID\nWHERE \n    a.userID = 'UserA' AND b.userID = 'UserB';