DELETE a\nFROM a  -- first table\nINNER JOIN b -- second table\n      ON b.ID = a.ID\n      AND b.Name = a.Name\n      AND b.Foo = a.Foo\n      AND b.Bar = a.Bar