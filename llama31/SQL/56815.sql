SELECT Product_Id, category, priority, atribute1, atribute2\nFROM YourTable\nORDER BY category, \n         CASE WHEN priority IS NULL THEN 1 ELSE 0 END, \n         priority;