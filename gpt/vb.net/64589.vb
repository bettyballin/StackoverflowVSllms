Imports Microsoft.VisualStudio.TestTools.UnitTesting\n\n<TestClass>\nPublic Class CalculatorTests\n\n    <TestMethod>\n    Public Sub Add_TwoNumbers_ReturnsSum()\n        ' Arrange\n        Dim calc As New Calculator()\n        Dim a As Integer = 5\n        Dim b As Integer = 10\n\n        ' Act\n        Dim result As Integer = calc.Add(a, b)\n\n        ' Assert\n        Assert.AreEqual(15, result)\n    End Sub\n\nEnd Class\n\nPublic Class Calculator\n    Public Function Add(a As Integer, b As Integer) As Integer\n        Return a + b\n    End Function\nEnd Class