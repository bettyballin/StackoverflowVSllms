#!/usr/bin/env python3\n   import time\n\n   # Sleep for 5 minutes (300 seconds)\n   time.sleep(300)\n\n   # Print the HTTP response headers\n   print("Content-Type: text/html")\n   print()\n   print("<html><body><h1>This is a simulated hung web service.</h1></body></html>")