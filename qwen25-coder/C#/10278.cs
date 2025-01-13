// Example of setting up a simple POST request to play sound on Nabaztag using C#\n   using System.Net;\n\n   public void PlaySound(string tagSerialNumber) {\n       var request = (HttpWebRequest)WebRequest.Create("http://api.nabaztag.com/v1/usb/");\n       request.Method = "POST";\n       string postData = $"sn={tagSerialNumber}&src=0&msg=<led id='0' /><led id='7' r='255' g='255' b='255' /><led id='1' r='255' g='255' b='255' /><sound src='http://www.nabaztag.com/sounds/en/alarm.mp3'/>";\n       byte[] byteArray = Encoding.UTF8.GetBytes(postData);\n       request.ContentType = "application/x-www-form-urlencoded";\n       request.ContentLength = byteArray.Length;\n\n       using (Stream dataStream = request.GetRequestStream()) {\n           dataStream.Write(byteArray, 0, byteArray.Length);\n       }\n\n       using (WebResponse response = request.GetResponse()) {}\n   }