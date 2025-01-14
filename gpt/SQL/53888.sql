CREATE TABLE SpaceQuadrant (\n    ID INT NOT NULL PRIMARY KEY,\n    EntryName VARCHAR(255) NOT NULL\n);\n\nCREATE TABLE SpaceCoordinate (\n    ID INT NOT NULL PRIMARY KEY,\n    X INT NOT NULL,\n    Y INT NOT NULL,\n    Z INT NOT NULL\n);\n\nCREATE TABLE SpaceObject (\n    ID INT NOT NULL PRIMARY KEY,\n    ObjectName VARCHAR(255) NOT NULL,\n    Description TEXT\n);\n\nCREATE TABLE SpaceMapping (\n    QuadrantID INT NOT NULL,\n    CoordinateID INT NOT NULL,\n    ObjectID INT NOT NULL,\n    PRIMARY KEY (QuadrantID, CoordinateID),\n    FOREIGN KEY (QuadrantID) REFERENCES SpaceQuadrant(ID),\n    FOREIGN KEY (CoordinateID) REFERENCES SpaceCoordinate(ID),\n    FOREIGN KEY (ObjectID) REFERENCES SpaceObject(ID)\n);