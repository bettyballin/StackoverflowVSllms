Public Class Blah\n    Public Sub Foo()\n        ' Method implementation\n    End Sub\nEnd Class\n\nModule Program\n    Sub Main()\n        Dim blahInstance As New Blah()\n        Dim methodName = GetMethodName(Of Blah)(Sub() blahInstance.Foo())\n        \n        Console.WriteLine(methodName)  ' Outputs: Foo\n    End Sub\nEnd Module