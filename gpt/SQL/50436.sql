SELECT Author.AID, Author.Name\nFROM Author\nLEFT JOIN AuthorOfTitle ON Author.AID = AuthorOfTitle.AID\nWHERE AuthorOfTitle.AID IS NULL;