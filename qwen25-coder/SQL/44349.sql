CREATE TABLE Pages (\n    PageID INT PRIMARY KEY,\n    PageName NVARCHAR(100),\n    Description NVARCHAR(255)\n);\n\nCREATE TABLE Controls (\n    ControlID INT PRIMARY KEY,\n    ControlType NVARCHAR(50), -- e.g., 'Textbox', 'Dropdown'\n    DefaultProperties XML\n);\n\nCREATE TABLE ControlPositions (\n    PositionID INT PRIMARY KEY,\n    PageID INT FOREIGN KEY REFERENCES Pages(PageID),\n    ControlID INT FOREIGN KEY REFERENCES Controls(ControlID),\n    X INT, Y INT,\n    Width INT, Height INT\n);\n\nCREATE TABLE DataBindings (\n    BindingID INT PRIMARY KEY,\n    ControlID INT FOREIGN KEY REFERENCES Controls(ControlID),\n    DataSource NVARCHAR(255)\n);