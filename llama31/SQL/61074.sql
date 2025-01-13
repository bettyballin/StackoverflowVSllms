CREATE TABLE audit_changes (\n  ID int identity(1,1) primary key,\n  CustomerID int,\n  TableName nvarchar(255),\n  ColumnName nvarchar(255),\n  OldValue nvarchar(255),\n  NewValue nvarchar(255),\n  ChangeType char(1),  -- 'I' for insert, 'U' for update, 'D' for delete\n  AuditDateTime datetime\n)