import urllib2\n\n# ... (your existing code to download the URL through a proxy)\n\n# Get the headers of the response\nheaders = sock.headers\n\n# Check the headers to determine the proxy type\nif 'Via' in headers or 'X-Forwarded-For' in headers:\n    print("Proxy is transparent")\nelif 'Proxy-Connection' in headers:\n    print("Proxy is non-transparent")\nelse:\n    print("Proxy is anonymous")