CREATE TABLE Borrowers (\n       BorrowerId INT IDENTITY(1,1) PRIMARY KEY,\n       GroupId INT,\n       PersonId INT,\n       FOREIGN KEY (GroupId) REFERENCES BorrowerGroup(GroupId),\n       FOREIGN KEY (PersonId) REFERENCES People(PersonId)\n   );