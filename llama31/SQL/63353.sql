UPDATE t2\nSET t2.pubVisited = NULL\nFROM table2 t2\nINNER JOIN table1 t1 ON t2.playerID = t1.playerID\nWHERE t1.nationalities = 'England';