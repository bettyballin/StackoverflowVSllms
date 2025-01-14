CREATE TABLE Category (\n    CategoryID INT PRIMARY KEY,\n    Name VARCHAR(255),\n    ParentCategoryID INT,  -- Foreign key referencing CategoryID in the same table\n    FOREIGN KEY (ParentCategoryID) REFERENCES Category(CategoryID)\n);