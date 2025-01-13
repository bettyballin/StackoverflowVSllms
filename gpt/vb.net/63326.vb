Public Sub SomeMethod(someControl As Object)\n    On Error Goto ErrHandler\n    \n    Dim someSpecificControl As SpecificControl\n    \n    ' Check if the control is a UserControl\n    If TypeOf someControl Is UserControl Then\n        ' Check if it can be cast to SpecificControl\n        If TypeOf someControl Is SpecificControl Then\n            Set someSpecificControl = someControl\n        End If\n    End If\n    \n    If someSpecificControl Is Nothing Then\n        Exit Sub\n    End If\n    \n    ' Do stuff to the control\n    \n    Exit Sub\n    \nErrHandler:\n    ' Handle errors\n    MsgBox "An error occurred: " & Err.Description\nEnd Sub