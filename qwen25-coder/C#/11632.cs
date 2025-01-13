// Selecting specific columns - potentially more efficient\nvar person = from p in [DataContextObject].Persons\n             where p.PersonsID == 1\n             select new { p.PersonsID, p.PersonsAdress, p.PersonsZipcode };\n\n// Selecting all columns - may be less efficient with large tables\nvar personAllColumns = from p in [DataContextObject].Persons\n                       where p.PersonsID == 1\n                       select p;