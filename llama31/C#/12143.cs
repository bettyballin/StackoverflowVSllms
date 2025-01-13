using Moq;\nusing NUnit.Framework;\n\npublic class SalesOrderRepositoryTests\n{\n    [Test]\n    public void GetSalesOrder_ValidId_ReturnsSalesOrder()\n    {\n        // Arrange\n        var mockDbContext = new Mock<DbContext>();\n        var salesOrderRepository = new SalesOrderRepository(mockDbContext.Object);\n\n        // Act\n        var salesOrder = salesOrderRepository.GetSalesOrder(1);\n\n        // Assert\n        Assert.IsNotNull(salesOrder);\n    }\n}