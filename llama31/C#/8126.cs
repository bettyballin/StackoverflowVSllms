private void BackgroundMethod()\n{\n    // Do some work on a background thread...\n\n    // Invoke a method on the UI thread\n    Dispatcher.BeginInvoke(new Action(() =>\n    {\n        // Update the UI here\n    }));\n}