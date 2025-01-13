[TestMethod]\n    public void TestRegression()\n    {\n        string pdfPath = "path/to/sample.pdf";\n        Report expectedReport = new Report { WordCount = 500, ImageCount = 10 };\n        Report actualReport = PdfProcessor.Process(pdfPath);\n        \n        Assert.AreEqual(expectedReport.WordCount, actualReport.WordCount);\n        Assert.AreEqual(expectedReport.ImageCount, actualReport.ImageCount);\n    }