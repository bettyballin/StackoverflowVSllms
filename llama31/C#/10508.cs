using (SqlCommand searchResult = new SqlCommand("SELECT ItemID, Name, RelDate, Price, Status FROM item_k WHERE ',' + @itemIDs + ',' LIKE '%,' + CONVERT(VARCHAR, itemID) + ',%'", searchCon))