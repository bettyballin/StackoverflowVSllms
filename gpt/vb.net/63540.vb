Sub Application_Error(ByVal sender As Object, ByVal e As EventArgs)\n    Dim exception As Exception = Server.GetLastError()\n    LogExceptionToFile(exception)\n    LogExceptionToEventLog(exception)\n    ' or using log4net\n    Logger.LogException(exception)\nEnd Sub