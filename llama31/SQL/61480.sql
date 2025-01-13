SELECT b.* \nFROM Books b \nJOIN BookAuthors ba ON b.BookID = ba.BookID \nJOIN Authors a ON ba.AuthorID = a.AuthorID \nWHERE a.AuthorID = 1;