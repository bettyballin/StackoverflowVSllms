Using cn As New System.Data.SqlClient.SqlConnection()\n    cn.Open()\n    ' Do a bunch of other stuff with commands and datareaders here\n    ' No need to explicitly close the connection\nEnd Using