SELECT \n  t.Post_ID, \n  t.Date, \n  tl.Title, \n  t.Text\nFROM \n  Post t\n  JOIN Top_Level tl ON t.ID = tl.Post_ID\nUNION ALL\nSELECT \n  t.Post_ID, \n  c.Date, \n  tl.Title, \n  c.Text\nFROM \n  Post t\n  JOIN Comment c ON t.ID = c.Post_ID\n  JOIN Top_Level tl ON c.TopLv_ID = tl.Post_ID\nORDER BY \n  Date DESC;