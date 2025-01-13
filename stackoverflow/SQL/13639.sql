declare @oldId as int\ndeclare @newId as int\n\nselect @oldId = Min(ParentId) from OldTable1 \n\nwhile not @oldId is null\nbegin\n    Insert Into NewTable1 (Name)\n    Select Name from OldTable1 where ParentId = @oldId\n\n    Select @newId = SCOPE_IDENTITY()\n\n    Insert Into NewTable2 (ParentId, Foo)\n    Select @newId, Foo From OldTable2 Where ParentId = @oldId\n\n    select @oldId = Min(ParentId) from OldTable1 where ParentId > @oldId\n\nend