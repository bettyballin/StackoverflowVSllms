Dim FromIp As String = "192.168.1.1"\n    Dim str As String\n    str = FromIp.Substring(FromIp.LastIndexOf(".") + 1).ToString()\n    MessageBox.Show(str)