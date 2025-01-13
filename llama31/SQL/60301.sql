SELECT \n    H1.Id, \n    H1.Status, \n    H1.BatchRef, \n    H1.ItemCount\nFROM \n    HistoryTable H1\nINNER JOIN \n(\n    SELECT \n        Id, \n        MAX(Status) as MaxStatus\n    FROM \n        HistoryTable\n    WHERE \n        BatchRef = @BatchRef\n    GROUP BY \n        Id\n) H2 \nON \n    H1.Id = H2.Id AND H1.Status = H2.MaxStatus\nWHERE \n    H1.BatchRef = @BatchRef;