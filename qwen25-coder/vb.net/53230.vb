Try\n    ' Your application startup code here\nCatch ex As Exception\n    Dim errorMessage = "An unexpected error occurred: " & ex.Message\n    Dim stackTrace = ex.StackTrace\n\n    ' Log the error details (use a logging library for production)\n    System.IO.File.AppendAllText("log.txt", $"{DateTime.Now}: {errorMessage} - StackTrace: {stackTrace}" & vbCrLf)\n\n    MessageBox.Show(errorMessage, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error)\nEnd Try