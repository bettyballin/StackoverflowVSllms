Imports Moq\n\nPublic Class MyTest\n    <Test>\n    Public Sub MyTest()\n        Dim mock = New Mock(Of IMyInterface)()\n        mock.Setup(Function(m) m.DoSomething()).Returns(True)\n        ' Use mock.Object to access the mock object\n        Dim result = mock.Object.DoSomething()\n        Assert.IsTrue(result)\n    End Sub\nEnd Class