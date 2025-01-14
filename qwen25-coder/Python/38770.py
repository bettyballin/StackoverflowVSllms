import cgi\nfrom urllib.parse import unquote\n\n# Example for cgi\nform = cgi.FieldStorage()\ntext_field_value = form.getvalue('name')  # This will be a Unicode string\n\n# Example for urllib\nencoded_text = 'hello%20world'\ndecoded_text = unquote(encoded_text)  # Decoded to Unicode string\nprint(decoded_text)\n\nimport urllib.request\n\nresponse = urllib.request.urlopen('http://example.com')\nhtml_bytes = response.read()  # This will be bytes\nhtml_str = html_bytes.decode('utf-8')  # Decode bytes to Unicode string\nprint(html_str)