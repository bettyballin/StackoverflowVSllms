SELECT TableB.con_number\nFROM TableB\nWHERE NOT EXISTS (SELECT 1 \n                  FROM TableA \n                  WHERE TableA.con_number = TableB.con_number);