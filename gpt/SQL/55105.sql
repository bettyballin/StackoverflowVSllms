-- Common Folder Table\nCREATE TABLE Folder\n(\n    ID INT IDENTITY PRIMARY KEY,\n    ParentID INT FOREIGN KEY REFERENCES Folder(ID),\n    IsDynamic BIT NOT NULL DEFAULT 0\n);\n\n-- Static Folder Table\nCREATE TABLE FolderStatic\n(\n    FolderID INT PRIMARY KEY FOREIGN KEY REFERENCES Folder(ID),\n    FolderName NVARCHAR(50) NOT NULL\n);\n\n-- Dynamic Folder Table\nCREATE TABLE FolderDynamic\n(\n    FolderID INT PRIMARY KEY FOREIGN KEY REFERENCES Folder(ID),\n    DynamicFieldID INT FOREIGN KEY REFERENCES DynamicField(ID) -- Assuming DynamicField table exists\n);