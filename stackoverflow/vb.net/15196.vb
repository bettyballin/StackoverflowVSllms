For Each p As Person In context.Persons\n   ds.Person.AddPersonRow(p.Id, p.FirstName, p.LastName)\nNext