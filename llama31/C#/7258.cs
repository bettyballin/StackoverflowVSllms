IBM.Data.Informix.IfxConnection c = new IBM.Data.Informix.IfxConnection("...");\nc.Open();\nIBM.Data.Informix.IfxCommand cmd = new IBM.Data.Informix.IfxCommand("SELECT id,data FROM aaa", c);\nIBM.Data.Informix.IfxDataReader r = cmd.ExecuteReader();\nwhile (r.Read()) {\n    IBM.Data.Informix.IfxBlob blob = r.GetIfxBlob(1);\n    Debug.WriteLine(blob.GetType());\n}\nc.Close();