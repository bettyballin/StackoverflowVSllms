Dim ip As String = Request.ServerVariables("HTTP_X_FORWARDED_FOR")\nDim remoteAddr As String = Request.ServerVariables("REMOTE_ADDR")\n\nIf ip <> "" AndAlso ip <> remoteAddr Then\n    ' Flag the request for further inspection\n    ' ...\nElseIf ip = "" Then\n    ip = remoteAddr\nEnd If