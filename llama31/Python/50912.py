import urllib.request\n\n# fetch some data from a URL\nresponse = urllib.request.urlopen('https://example.com')\n\n# get the response data as bytes\ndata = response.read()\n\n# decode the bytes to a Unicode string using UTF-8 encoding\ntext = data.decode('utf-8')\n\nprint(text)