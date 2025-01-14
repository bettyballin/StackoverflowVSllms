Public Class Program\n    Public Event X()\n\n    Public Sub New()\n        AddHandler X, AddressOf EventHandler\n    End Sub\n\n    Public Sub RaiseEventX()\n        For Each d As [Delegate] In X.GetInvocationList()\n            Dim handler As Action = CType(d, Action)\n            Task.Run(Sub() handler.Invoke())\n        Next\n    End Sub\n\n    Private Sub EventHandler()\n        Console.WriteLine("Event handler executed asynchronously.")\n    End Sub\nEnd Class