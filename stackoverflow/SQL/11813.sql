UPDATE WebbikesProducts \nSET Price = Price * 1.05 \nWHERE ISNUMERIC(SubString( UniqueID, 3, 3 )) = 1\nAND Convert( Integer, SubString( UniqueID, 3, 3 )) = 125