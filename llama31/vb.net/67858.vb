Dim re As New Regex("(?<field>(?:[^"",\r\n]+)|\"(?:[^\"|\"\""]+ \"\")\")|(?<field>))(,|(?<rowbreak>\r\n|\n|$))")