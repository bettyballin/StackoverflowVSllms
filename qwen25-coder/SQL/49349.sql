SELECT DISTINCT Books.*\nFROM Books\nLEFT JOIN KeywordsLink ON Books.CopyID = KeywordsLink.BookID\nLEFT JOIN Keywords ON KeywordsLink.KeywordID = Keywords.ID\nWHERE Books.Title LIKE '%Joel%'\n   OR Books.Author LIKE '%Spolsky%'\n   OR Books.Publisher LIKE '%PublisherName%'  -- Add this line if you want to include Publisher search\n   OR Keywords.Name LIKE '%good%';