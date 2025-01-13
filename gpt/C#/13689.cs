[TestFixture]\npublic class Tests\n{\n    [Test]\n    [TestCase(null)]\n    [TestCase("")]\n    public void MyMethod_should_fail_if_param_is_null_or_empty(string param)\n    {\n        // Arrange\n        var myclass = new MyClass();\n\n        // Act & Assert\n        Assert.Throws<ArgumentNullException>(() => myclass.MyMethod(param));\n    }\n}