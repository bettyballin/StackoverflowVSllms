Public Class SuperClass\n    Protected Sub DoSomethingInternal()\n        ' implementation\n    End Sub\nEnd Class\n\nPublic Class SubClass\n    Inherits SuperClass\n\n    Public Sub DoSomething()\n        DoSomethingInternal()\n    End Sub\nEnd Class