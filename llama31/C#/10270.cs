using OpenQA.Selenium;\nusing OpenQA.Selenium.Chrome;\n\nclass MyTest {\n  [Test]\n  public void TestLogin() {\n    // Set up the browser\n    IWebDriver driver = new ChromeDriver();\n    driver.Navigate().GoToUrl("https://example.com/login");\n\n    // Enter username and password\n    driver.FindElement(By.Name("username")).SendKeys("username");\n    driver.FindElement(By.Name("password")).SendKeys("password");\n\n    // Click the login button\n    driver.FindElement(By.CssSelector("button[type='submit']")).Click();\n\n    // Verify that the login was successful\n    Assert.IsTrue(driver.Title.Contains("Welcome"));\n  }\n}