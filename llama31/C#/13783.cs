OleDbCommand cmd = new OleDbCommand();\ncmd.CommandText = "ALTER TABLE myTable ADD COLUMN myHyperlink MEMO HYPERLINK";\ncmd.ExecuteNonQuery();