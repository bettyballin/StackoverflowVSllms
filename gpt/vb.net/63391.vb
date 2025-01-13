Private Declare Function GetTickCount Lib "kernel32" () As Long\n\nSub MeasureTime()\n    Dim startTime As Long\n    Dim endTime As Long\n    Dim elapsedTime As Long\n    \n    ' Get the start time in milliseconds\n    startTime = GetTickCount()\n    \n    ' Place the code you want to measure here\n    ' For example, a loop that takes some time to execute\n    Dim i As Long\n    For i = 1 To 1000000\n        ' Simulate work\n    Next i\n    \n    ' Get the end time in milliseconds\n    endTime = GetTickCount()\n    \n    ' Calculate the elapsed time\n    elapsedTime = endTime - startTime\n    \n    ' Output the elapsed time\n    MsgBox "Elapsed time: " & elapsedTime & " milliseconds"\nEnd Sub