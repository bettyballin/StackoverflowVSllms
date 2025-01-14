SELECT p.ID, p.entry, c.ID, c.name, cb.ID AS bindingID, cb.postID, cb.categoryID\nFROM Post AS p\nLEFT JOIN CategoryBinding AS cb ON p.ID = cb.postID\nLEFT JOIN Category AS c ON cb.categoryID = c.ID\nWHERE EXISTS (\n    SELECT 1\n    FROM CategoryBinding cb2\n    JOIN Category c2 ON cb2.categoryID = c2.ID\n    WHERE cb2.postID = p.ID AND c2.name = 'asp'\n);