class CRoom:\n    def __init__(self):\n        self.People = {}\n        self.NextId = 0\n\n    def AddPerson(self, FirstName, SecondName, Gender):\n        Id = self.NextId\n        self.NextId += 1\n\n        from person import CPerson  # Import CPerson here\n        Person = CPerson(FirstName, SecondName, Gender, Id, self)\n        self.People[Id] = Person\n        return Person\n\n    def FindDoorAndLeave(self, PersonId):\n        del self.People[PersonId]