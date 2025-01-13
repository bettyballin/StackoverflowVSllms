SELECT b.Book_Title, \n       COUNT(CASE WHEN s.Book_ID IS NOT NULL THEN 1 ELSE NULL END) AS sales_count\nFROM Book b\nLEFT JOIN Sold s ON b.Book_ID = s.Book_ID\nGROUP BY b.Book_Title;