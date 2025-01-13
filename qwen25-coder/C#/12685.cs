// This would execute one SQL query to fetch all people under 18 into memory\nvar peopleList = (from p in Person where p.age < 18 select p).ToList();\n\n// This filters the in-memory list, NOT creating a new database query\nvar otherPeople = from p in peopleList where p.firstName == "Daniel" select p;