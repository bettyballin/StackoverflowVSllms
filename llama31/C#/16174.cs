using Moq;\nusing System.Data;\nusing System.Data.SqlClient;\nusing Xunit;\n\npublic class DatabaseTests\n{\n    [Fact]\n    public void ExecuteQuery_ReturnsDataTable_WhenQueryIsValid()\n    {\n        // Arrange\n        var mockConnection = new Mock<SqlConnection>();\n        var mockCommand = new Mock<SqlCommand>();\n        var mockParameters = new Mock<SqlParameterCollection>();\n        var query = "SELECT * FROM table";\n        var expectedDataTable = new DataTable();\n\n        mockCommand.Setup(c => c.ExecuteNonQuery()).Returns(1);\n        mockCommand.Setup(c => c.ExecuteReader()).Returns(new Mock<SqlDataReader>().Object);\n\n        // Act\n        var result = ExecuteQuery(mockConnection.Object, query, mockParameters.Object);\n\n        // Assert\n        Assert.NotNull(result);\n        Assert.IsType<DataTable>(result);\n    }\n\n    [Fact]\n    public void ExecuteQuery_ThrowsException_WhenQueryIsInvalid()\n    {\n        // Arrange\n        var mockConnection = new Mock<SqlConnection>();\n        var mockCommand = new Mock<SqlCommand>();\n        var mockParameters = new Mock<SqlParameterCollection>();\n        var query = "INVALID QUERY";\n\n        mockCommand.Setup(c => c.ExecuteNonQuery()).Throws(new SqlException());\n\n        // Act and Assert\n        Assert.Throws<SqlException>(() => ExecuteQuery(mockConnection.Object, query, mockParameters.Object));\n    }\n}