// Example ASMX call in Silverlight\nWebClient client = new WebClient();\nclient.DownloadStringCompleted += (s, e) => {\n    string result = e.Result;\n};\nclient.DownloadStringAsync(new Uri("http://serviceurl/Service.asmx/Method"));