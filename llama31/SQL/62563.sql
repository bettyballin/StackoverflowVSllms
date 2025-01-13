CREATE TABLE RestaurantChains (\n    ChainID INT PRIMARY KEY,\n    Name VARCHAR(255)\n);\n\nCREATE TABLE Restaurants (\n    RestaurantID INT PRIMARY KEY,\n    ChainID INT,\n    Name VARCHAR(255),\n    FOREIGN KEY (ChainID) REFERENCES RestaurantChains(ChainID)\n);\n\nCREATE TABLE MenuItems (\n    MenuItemID INT PRIMARY KEY,\n    RestaurantID INT,\n    Name VARCHAR(255),\n    FOREIGN KEY (RestaurantID) REFERENCES Restaurants(RestaurantID)\n);\n\nCREATE TABLE CommentTargets (\n    TargetID INT PRIMARY KEY,\n    OwnerType VARCHAR(20) CHECK (OwnerType IN ('Chain', 'Restaurant', 'MenuItem')),\n    OwnerID INT,\n    UNIQUE (OwnerType, OwnerID)\n);\n\nCREATE TABLE Comments (\n    CommentID INT PRIMARY KEY,\n    TargetID INT,\n    CommentText TEXT,\n    FOREIGN KEY (TargetID) REFERENCES CommentTargets(TargetID)\n);\n\nCREATE TABLE RatingTargets (\n    TargetID INT PRIMARY KEY,\n    OwnerType VARCHAR(20) CHECK (OwnerType IN ('Chain', 'Restaurant', 'MenuItem')),\n    OwnerID INT,\n    UNIQUE (OwnerType, OwnerID)\n);\n\nCREATE TABLE Ratings (\n    RatingID INT PRIMARY KEY,\n    TargetID INT,\n    Rating INT,\n    FOREIGN KEY (TargetID) REFERENCES RatingTargets(TargetID)\n);