SELECT \n  cost, \n  participant, \n  CAST(cost / participant AS INT) AS single_cost\nFROM \n  your_table;