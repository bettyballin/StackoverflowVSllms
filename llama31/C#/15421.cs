var people = new[] { new Person("John", 30), new Person("Alice", 25), new Person("Bob", 30) };\nvar groupedPeople = people.GroupBy(p => p.Age);