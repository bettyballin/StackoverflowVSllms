SELECT \n    Name,\n    Address1 + CHAR(13) + CHAR(10) + Address2 + CHAR(13) + CHAR(10) + Address3 AS FullAddress\nFROM \n    YourTable