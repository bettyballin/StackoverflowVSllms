Dim http\nSet http = CreateObject("MSXML2.XMLHTTP")\n\nhttp.setProxy 2, "localhost:8888" ' 2 = SXH_PROXY_SET_DIRECT\n\nhttp.open "POST", "http://example.com", False\nhttp.send "your_data_here"