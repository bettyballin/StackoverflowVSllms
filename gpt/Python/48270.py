#!/usr/bin/env python\n\nimport cgi\nimport os\nimport cgitb; cgitb.enable()  # for troubleshooting\n\n# Create instance of FieldStorage\nform = cgi.FieldStorage()\n\n# Get the file item\nfileitem = form['file']\n\n# Check if the file was uploaded\nif fileitem.filename:\n    # Get the filename\n    filename = os.path.basename(fileitem.filename)\n    \n    # Open the file in binary mode\n    with open('/tmp/' + filename, 'wb') as f:\n        f.write(fileitem.file.read())\n    \n    print("Content-Type: text/html\n")\n    print("<html><body>")\n    print("<h2>File uploaded successfully.</h2>")\n    print("</body></html>")\nelse:\n    print("Content-Type: text/html\n")\n    print("<html><body>")\n    print("<h2>No file was uploaded.</h2>")\n    print("</body></html>")