Private Sub CallComPlusComponent()\n    On Error GoTo ErrorHandler\n\n    ' Replace 'YourComPlusComponent.YourInterface' with the actual ProgID of your COM+ component\n    Dim comPlusInstance As Object\n    Set comPlusInstance = CreateObject("YourComPlusComponent.YourInterface")\n\n    ' Replace 'YourMethod' with the actual method name you want to call\n    comPlusInstance.YourMethod\n\n    Exit Sub\n\nErrorHandler:\n    MsgBox "An error occurred: " & Err.Description\nEnd Sub