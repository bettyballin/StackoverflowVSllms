<%\n' Retrieve session variables\nDim cartItems\ncartItems = Session("cartItems")\n\n' Redirect to the HTTPS version with session variables in the query string\nResponse.Redirect "https://example.com/beginCheckoutProcess.asp?cartItems=" & Server.URLEncode(cartItems)\n%>