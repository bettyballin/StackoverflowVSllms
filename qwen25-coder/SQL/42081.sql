SELECT UserID, COUNT(*) as PostCount \nFROM postings \nGROUP BY UserID \nORDER BY PostCount DESC;