Dim ds As New PeopleDataSet()\nUsing context As New PeopleDataContext()\n    Dim result = (From p In context.Persons\n                  Select ds.Person.AddPersonRow(p.Id, p.FirstName, p.LastName)).ToList()\nEnd Using