[TestMethod]\n    public void TestWordCount()\n    {\n        string sampleText = "This is a sample text with seven words.";\n        int expectedCount = 7;\n        int actualCount = WordCounter.CountWords(sampleText);\n        Assert.AreEqual(expectedCount, actualCount);\n    }