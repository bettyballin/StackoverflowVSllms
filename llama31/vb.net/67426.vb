Private Sub MyMethod()\n    On Error GoTo ErrorHandler\n\n    ' Your code here...\n\n    Exit Sub\n\nErrorHandler:\n    Dim stackTrace As New System.Diagnostics.StackTrace()\n    Dim stackFrame As System.Diagnostics.StackFrame = stackTrace.GetFrame(0)\n    Dim methodName As String = stackFrame.GetMethod().Name\n\n    Console.WriteLine("Error in method: " & methodName)\n    Console.WriteLine("Stack Trace:")\n    Console.WriteLine(stackTrace.ToString())\nEnd Sub