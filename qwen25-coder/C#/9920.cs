[TestMethod]\npublic void Should_update_foo_to_active_inside_of_repository()\n{\n    // arrange\n    var repo = MockRepository.GenerateMock<IRepository>();\n    var foo = new Foo() { ID = 1, IsActive = false };\n    var target = new Presenter(repo);\n\n    Expect.Call(() => repo.ActivateFoo(foo)).Do(new Action<Foo>(f =>\n    {\n        f.IsActive = true;\n    })).Return(true);\n    \n    // act\n    target.Activate(foo);\n\n    // assert\n    Assert.IsTrue(foo.IsActive);\n    repo.VerifyAllExpectations();\n}