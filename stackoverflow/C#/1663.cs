using(System.Net.WebClient client = new System.Net.WebClient())\n{\n  string html = client.DownloadString("http://www.google.com");\n}