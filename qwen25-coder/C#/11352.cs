// Example REST call in Silverlight using WebClient\nWebClient client = new WebClient();\nclient.DownloadStringCompleted += (s, e) => {\n    string result = e.Result;\n};\nclient.DownloadStringAsync(new Uri("http://serviceurl/api/resource"));