UPDATE Table1\nSET AlertDate = getutcdate()\nOUTPUT inserted.Id\nWHERE AlertDate IS NULL;