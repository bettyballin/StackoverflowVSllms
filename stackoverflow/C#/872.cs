string username = "your";\nstring password = "password";\nHttpWebRequest request = (HttpWebRequest)WebRequest.Create("https://moje.azet.sk/prihlasenie.phtml?KDE=www.azet.sk%2Findex.phtml%3F");\nusing (StreamWriter writer = new StreamWriter(request.GetRequestStream(), Encoding.ASCII))\n{\n    writer.Write("nick=" + username + "&password=" + password);\n}\n\nHttpWebResponse response = (HttpWebResponse)request.GetResponse();\n//Retrieve your cookie that id's your session\n//response.Cookies\n\nusing (StreamReader reader = new StreamReader(response.GetResponseStream())\n{\n    Console.WriteLine(reader.ReadToEnd());\n}