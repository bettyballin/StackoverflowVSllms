[TestMethod]\n  public void ValidateCustomerName() {\n      // Arrange\n      var customer = new Customer { Name = "" };\n      \n      // Act\n      bool isValid = customer.IsValid;\n      \n      // Assert\n      Assert.IsFalse(isValid, "Validation should have failed for an empty customer name.");\n  }