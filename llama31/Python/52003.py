import urllib.request\n\n# Define the proxy URL\nproxy_url = 'http://your-proxy-server.com:8080'\n\n# Create a ProxyHandler object\nproxy_handler = urllib.request.ProxyHandler({\n    'http': proxy_url,\n    'https': proxy_url\n})\n\n# Create an opener that uses the proxy\nopener = urllib.request.build_opener(proxy_handler)\n\n# Make the request\nresponse = opener.open('http://www.google.com')\n\n# Print the response\nprint(response.read())