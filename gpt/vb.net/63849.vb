<%\nFunction SanitizeInput(inputStr)\n    SanitizeInput = Replace(inputStr, "<", "&lt;")\n    SanitizeInput = Replace(SanitizeInput, ">", "&gt;")\n    SanitizeInput = Replace(SanitizeInput, """", "&quot;")\n    SanitizeInput = Replace(SanitizeInput, "'", "&#39;")\nEnd Function\n%>\n\n<% \nDim rawInput\nrawInput = Request("userInput")\nDim sanitizedInput\nsanitizedInput = SanitizeInput(rawInput)\nResponse.Write HTMLEncode(sanitizedInput)\n%>