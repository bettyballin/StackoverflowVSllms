SELECT COUNT(*) AS `Rows`, UserID\nFROM `postings`\nGROUP BY UserID\nORDER BY `Rows` DESC\nLIMIT 1