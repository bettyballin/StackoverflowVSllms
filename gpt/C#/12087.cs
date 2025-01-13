public class Person\n{\n    private string _name = "John";\n    private string _surname = string.Empty;\n\n    public string Name\n    {\n        get { return _name; }\n    }\n\n    public string Surname\n    {\n        get { return _surname; }\n        set\n        {\n            if (string.IsNullOrWhiteSpace(value))\n            {\n                throw new ArgumentException("Surname cannot be empty");\n            }\n            _surname = value;\n        }\n    }\n}\n\n[TestFixture]\npublic class PersonTests\n{\n    [Test]\n    public void SurnameProperty_ShouldThrowException_WhenSetToEmpty()\n    {\n        // Arrange\n        var person = new Person();\n\n        // Act & Assert\n        Assert.Throws<ArgumentException>(() => person.Surname = string.Empty);\n    }\n\n    [Test]\n    public void SurnameProperty_ShouldReturnCorrectValue_AfterSetting()\n    {\n        // Arrange\n        var person = new Person();\n        var expectedSurname = "Doe";\n\n        // Act\n        person.Surname = expectedSurname;\n        var actualSurname = person.Surname;\n\n        // Assert\n        Assert.AreEqual(expectedSurname, actualSurname);\n    }\n}