ALTER TABLE YourTableName\nADD CONSTRAINT CK_Type_Values CHECK (Type IN ('Black', 'White', 'Red', 'Blue'));