var queryStringParams = HttpUtility.ParseQueryString("param1=value1&param2=value2");\nstring hmac = QueryStringValidator.GenerateHmac(queryStringParams);\nstring url = $"http://example.com/page?{queryStringParams}&hmac={HttpUtility.UrlEncode(hmac)}";