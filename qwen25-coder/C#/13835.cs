[Given(@"I navigate to ""(.*)""")]\n   public void GivenINavigateTo(string url)\n   {\n       _driver.Navigate().GoToUrl(url);\n   }