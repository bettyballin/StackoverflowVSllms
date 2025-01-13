private static IE ie;\n\n[ClassInitialize]\npublic static void testInit(TestContext testContext)\n{\n    ie = new IE("http://news.bbc.co.uk");\n    ie.ReuseInstance = true; // Reuse the existing instance\n}\n\n[TestMethod]\npublic void testOne()\n{\n    Assert.IsTrue(ie.ContainsText("Low graphics"));\n}\n\n[TestMethod]\npublic void testTwo()\n{\n    ie = new IE(ie.ProcessID); // Reattach to the existing instance\n    Assert.IsTrue(ie.ContainsText("Low graphics"));\n}