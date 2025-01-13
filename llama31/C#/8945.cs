[Test]\npublic void InvalidEnumValue_ThrowsNotSupportedException()\n{\n    // Arrange\n    DiaryMode invalidMode = (DiaryMode)Enum.Parse(typeof(DiaryMode), "InvalidValue");\n\n    // Act and Assert\n    Assert.Throws<NotSupportedException>(() =>\n    {\n        // Call the method that contains the enum check\n        YourMethod(invalidMode);\n    });\n}