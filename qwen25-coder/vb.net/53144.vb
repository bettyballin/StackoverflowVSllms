Dim NFOData As New NFOData\n\nUsing sr As New StreamReader(filename)\n    While Not sr.EndOfStream\n        Dim line As String = sr.ReadLine()\n        ' Skip empty lines and headers like "Report 1 of 1"\n        If String.IsNullOrWhiteSpace(line) OrElse line.Contains("Report") Then Continue While\n        \n        Dim parts() As String = line.Split(New Char() {"="c}, StringSplitOptions.RemoveEmptyEntries)\n        If parts.Length < 2 Then Continue While\n\n        Dim key As String = parts(0).Trim()\n        Dim value As String = parts(1).Trim()\n\n        Select Case key\n            Case "job_name"\n                NFOData.JobName = value\n            Case "job_no"\n                NFOData.JobNo = value.Split(" "(c))(0) ' Extracts just the number part\n            Case "rprt_id"\n                NFOData.RprtId = value\n            Case "rprt_name"\n                NFOData.RprtName = value\n            Case "ftp_size"\n                NFOData.FtpSize = Convert.ToInt32(value)\n            Case "job_group_name"\n                NFOData.JobGroupName = value\n            Case "clas"\n                NFOData.Clas = value\n            Case "form"\n                NFOData.Form = Convert.ToInt32(value)\n            Case "user_id"\n                NFOData.UserId = value\n        End Select\n    End While\nEnd Using