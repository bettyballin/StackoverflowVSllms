SELECT * \nFROM tbA A\nJOIN tbB B ON A.ID = B.ID AND B.ID2 = C.ID2\nJOIN tbC C ON B.ID2 = C.ID2\nJOIN tbD D ON A.ID = D.ID AND C.ID3 = D.ID3 AND B.ID4 = D.ID4\nWHERE A.Foo = 'Foo';