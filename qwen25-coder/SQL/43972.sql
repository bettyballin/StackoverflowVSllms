ALTER TABLE Folders \nADD CONSTRAINT UC_Folder UNIQUE (Name, ParentFolderID);