WebBrowser1.Navigate("about:blank");\n   WebBrowser1.Dispose();\n   GC.Collect();\n   GC.WaitForPendingFinalizers();