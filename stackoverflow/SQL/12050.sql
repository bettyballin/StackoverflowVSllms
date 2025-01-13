CREATE TABLE FileSystemObject ( \n    ID int not null primary key identity,\n    Name varchar(100) not null,\n    ParentID int null references FileSystemObject(ID),\n    constraint uk_Path UNIQUE (Name, ParentID),\n    IsFolder bit not null\n)