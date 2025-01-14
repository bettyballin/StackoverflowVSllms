Dim ip As String = Request.ServerVariables("HTTP_X_FORWARDED_FOR")\nIf Not String.IsNullOrEmpty(ip) Then\n    ' Split the IPs and select the first one assuming the client is not behind a trusted proxy\n    Dim ips() As String = ip.Split(",")\n    ip = ips(0).Trim()\nEnd If\n\n' Optionally, verify if the IP should be trusted (e.g., internal or known proxies)\nIf Not IsTrustedIP(ip) Then\n    ' Fallback to REMOTE_ADDR if X-Forwarded-For is not trusted\n    ip = Request.ServerVariables("REMOTE_ADDR")\nEnd If\n\nFunction IsTrustedIP(ByVal ipAddress As String) As Boolean\n    ' Implement logic to check against a list of trusted PROXY IP addresses\n    Return False ' placeholder, replace with actual check\nEnd Functio