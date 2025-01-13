ThreadStart workerDelegate = delegate {\n    // Call your long-running method\n};\n\n// Create and configure the background worker with STA threading model\nusing (var workerThread = new Thread(workerDelegate))\n{\n    workerThread.SetApartmentState(ApartmentState.STA);\n    workerThread.Start();\n    workerThread.Join(); // If necessary to wait for thread completion, otherwise handle asynchronously\n}