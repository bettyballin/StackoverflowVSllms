Class ExampleClass\n    ' Original method name\n    Public Sub CalculateSum(ByVal num1 As Integer, ByVal num2 As Integer) As Integer\n        Return num1 + num2\n    End Sub\nEnd Class\n\n' After refactoring: Right-click on the method name and select Refactor -> Rename and type NewCalculateSum\nClass ExampleClass\n    ' New method name after renaming\n    Public Sub NewCalculateSum(ByVal num1 As Integer, ByVal num2 As Integer) As Integer\n        Return num1 + num2\n    End Sub\nEnd Class