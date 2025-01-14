' Example of basic timing in VB6 to help identify slow code sections\nPrivate Declare Function GetTickCount Lib "kernel32" () As Long\n\nSub ProfileExample()\n    Dim startTime As Long, endTime As Long\n    \n    ' Start the timer\n    startTime = GetTickCount()\n    \n    ' Code to profile goes here\n    Call SomeSlowProcedure()\n    \n    ' Stop the timer\n    endTime = GetTickCount()\n    \n    ' Output the time taken in milliseconds\n    Debug.Print "Time taken: " & (endTime - startTime) & " ms"\nEnd Sub\n\nSub SomeSlowProcedure()\n    Dim i As Integer\n    For i = 1 To 1000000\n        ' Simulate some work with a loop\n    Next i\nEnd Sub