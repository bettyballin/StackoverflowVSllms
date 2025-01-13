SELECT \n  COALESCE(Category, Category2) AS Category,\n  COUNT(*) AS Count\nFROM \n  Items\nGROUP BY \n  COALESCE(Category, Category2)