-- Assuming card names are unique and encapsulated in quotes in the ruling text\nINSERT INTO CardReferences (CardId, ReferencedCardId)\nSELECT DISTINCT r.Id AS CardId, c.Id AS ReferencedCardId\nFROM rulings r\nJOIN card c ON r.text LIKE '%' + QUOTENAME(c.Name, '"') + '%';