CREATE TEMPORARY TABLE CustomerMergeMap (\n       OldId INT PRIMARY KEY,\n       NewId INT FOREIGN KEY REFERENCES Customers(idCustomer) ON UPDATE CASCADE\n   );