using NUnit.Framework;\n\n[TestFixture]\npublic class MyTests\n{\n    [Test, Timeout(2000)] // Timeout specified in milliseconds (2000 ms = 2 seconds)\n    public void MyTest()\n    {\n        // Your test code here\n    }\n}