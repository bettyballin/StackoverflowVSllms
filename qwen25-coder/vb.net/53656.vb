Function HexStringToByteArray(hex As String) As Byte()\n    Dim numberChars As Integer = hex.Length\n    Dim bytes(numberChars \ 2 - 1) As Byte\n    For i As Integer = 0 To numberChars - 1 Step 2\n        bytes(i \ 2) = Convert.ToByte(hex.Substring(i, 2), 16)\n    Next\n    Return bytes\nEnd Function\n\nDim byteArrayToken As Byte() = HexStringToByteArray(stringToken)\nscSelectThing.CommandText = "select thing from tokenstable where token=@token"\nDim param As SqlParameter = scSelectThing.Parameters.Add("@token", SqlDbType.VarBinary, byteArrayToken.Length)\nparam.Value = byteArrayToken\nlbOutput2.Text = Convert.ToString(scSelectThing.ExecuteScalar())