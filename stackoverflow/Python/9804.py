try:\n    urllib.urlopen(\n        "http://example.com",\n        proxies={'http':'http://example.com:8080'}\n    )\nexcept IOError:\n    print "Connection error! (Check proxy)"\nelse:\n    print "All was fine"