<%\nDim data \n\n''// VBScript Strings cannot span multiple lines, we must use\n''// concatenation ("&") and line continuation markers ("_")\n''// (also, double quotes need to be escaped by *double* double quotes)\ndata = "" & _\n  "[" & _\n  "  {" & _\n  "    ""A"": ""test""," & vbCrLf & _\n  "    ""B"": ""test""," & vbCrLf & _\n  "    ""C"": ""test"""  & vbCrLf & _\n  "  }," & vbCrLf & _\n  "  {" & vbCrLf & _\n  "    ""A"": ""test""," & vbCrLf & _\n  "    ""B"": ""test""," & vbCrLf & _\n  "    ""C"": ""test""" & vbCrLf & _\n  "  }" & vbCrLf & _\n  "]"\n\nResponse.Write Request.QueryString("callback") & "(" & data & ")"\n%>