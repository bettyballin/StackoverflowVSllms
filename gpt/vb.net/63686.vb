Dim strSessionIDCookie As String = Regex.Replace(strCookies, "(.<em>)sessionid=(.</em>)(,|;)(.*)", "$2")