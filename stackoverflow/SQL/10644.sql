select a.Id, a.Name from Table1 a left outer join Table2 b on a.Name = b.Name where b.Id is null\nUNION ALL\nselect a.Id, a.Name from Table2 a left outer join Table1 b on a.Name = b.Name where b.Id is null