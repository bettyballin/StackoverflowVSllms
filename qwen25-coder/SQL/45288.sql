CREATE INDEX IX_FieldValues_GroupId_Value_Created\n  ON FieldValues (GroupId)\n  INCLUDE (Value, Created);