// Decode Base64 ViewState\n  string base64ViewState = "Base64EncodedStringHere";\n  byte[] decodedBytes = Convert.FromBase64String(base64ViewState);\n  string decodedString = System.Text.Encoding.UTF8.GetString(decodedBytes);