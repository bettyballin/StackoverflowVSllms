private void BackgroundMethod()\n{\n    // Do some work on a background thread...\n\n    // Invoke a method on the UI thread\n    Dispatcher.Invoke(() =>\n    {\n        // Update the UI here\n    });\n}