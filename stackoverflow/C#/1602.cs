catch(WebException ex)\n{\n    string message = ((HttpWebResponse)ex.Response).StatusDescription;\n}