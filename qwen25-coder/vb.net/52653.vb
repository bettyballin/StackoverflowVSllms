Dim confirmUrl As String = Request.ApplicationPath & "?v=" & reg.AuthKey\nDim text As String = IO.File.ReadAllText( _\n   ConfigurationManager.AppSettings("sign_up_confirm_email_text").Replace("~", _\n   Request.PhysicalApplicationPath))\nDim html As String = IO.File.ReadAllText( _\n   ConfigurationManager.AppSettings("sign_up_confirm_email_html").Replace("~", _\n   Request.PhysicalApplicationPath))\n\ntext = text.Replace("%%LINK%%", confirmUrl)\ntext = text.Replace("%%NAME%%", person.fname)\n\nhtml = html.Replace("%%LINK%%", confirmUrl)\nhtml = html.Replace("%%NAME%%", person.fname)