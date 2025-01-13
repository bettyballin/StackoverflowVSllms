[Test, Timeout(120000)] // 2 minutes\npublic void TestFileUpload()\n{\n    try\n    {\n        var fileUpload = browser.FileUpload(Find.ById("fileUploadId"));\n        fileUpload.Set("path_to_pdf");\n        browser.Button(Find.ById("submitButtonId")).Click();\n        \n        // Wait for upload to complete\n        browser.WaitUntil(() => browser.ContainsText("Upload Complete"), 60000); // Wait for up to 1 minute\n    }\n    catch (Exception ex)\n    {\n        // Log the exception for diagnostics\n        Console.WriteLine($"Exception during file upload: {ex.Message}");\n        throw;\n    }\n}