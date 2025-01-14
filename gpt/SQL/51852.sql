SELECT \n    c.Id,\n    c.FirstName,\n    c.LastName,\n    p.PhoneNumber,\n    p.Description,\n    p.Comment\nFROM \n    Contacts c\nLEFT JOIN \n    PhoneNumbers p ON c.Id = p.ContactId\nWHERE \n    c.Id = @ContactId;