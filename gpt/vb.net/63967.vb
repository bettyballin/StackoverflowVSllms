Dim conn As OleDbConnection\n\nconn = New OleDbConnection("Provider=Microsoft.Jet.OLEDB.4.0;Data Source=" _\n& Application.StartupPath & "\VFMS_DB.mdb;" _\n& "Jet OLEDB:System Database=Security.mdw;User ID=Ads;Password=1234;")