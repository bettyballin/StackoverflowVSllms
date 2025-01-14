CREATE TABLE ChangeHistory (\n       ChangeID NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,\n       TableName VARCHAR2(30),\n       Operation CHAR(1),\n       ChangeTime TIMESTAMP WITH TIME ZONE,\n       OldValue CLOB,\n       NewValue CLOB,\n       UserName VARCHAR2(30)\n   );