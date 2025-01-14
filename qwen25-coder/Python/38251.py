^(?:(?P<scheme>[a-z0-9+.\-]*):\/\/)? # Match scheme (http, https, etc.)\n(?:(?P<username>[^:]+):(?P<password>[^\@]+\@))? # Match username and password\n(?P<hostname>[^\/:@\s]+)               # Match hostname (mandatory)\n(?:\/(?P<path>[^?\#]*))?               # Match path\n(?:[?]?(?P<query>[^#\s]+))?            # Match query string\n(?:#[\s]*(?P<fragment>.*))?           # Match fragment