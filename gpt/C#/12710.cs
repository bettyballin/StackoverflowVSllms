using System;\nusing System.ComponentModel;\nusing System.Threading;\nusing System.Windows.Threading;\n\nprivate void bckgrndWrkrController_DoWork(object sender, DoWorkEventArgs e)\n{\n    BackgroundWorker worker = sender as BackgroundWorker;\n    if (worker != null)\n    {\n        controller.BackgroundWorker = worker;\n\n        Dispatcher dispatcher = Dispatcher.CurrentDispatcher; // Get the dispatcher for the current thread (UI thread)\n        Thread thread = new Thread(() => STAProcessSelection(e.Argument, dispatcher));\n        thread.SetApartmentState(ApartmentState.STA);\n        thread.Start();\n        thread.Join();\n\n        e.Result = processingResult;\n        e.Cancel = worker.CancellationPending;\n    }\n}\n\nprivate void STAProcessSelection(object argument, Dispatcher dispatcher)\n{\n    ISelection selection = argument as ISelection;\n    if (selection != null)\n    {\n        // Use dispatcher to marshal the call back to the UI thread\n        dispatcher.Invoke(() =>\n        {\n            processingResult = controller.ProcessSelection(selection);\n        });\n    }\n}\n\nprivate void bckgrndWrkrController_RunWorkerCompleted(object sender, RunWorkerCompletedEventArgs e)\n{\n    if (e.Error != null)\n    {\n        MessageBox.Show(e.Error.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);\n    }\n    else if (e.Result is bool)\n    {\n        // Making sure the thread was not cancelled after we got the result\n        processingResult = (bool)e.Result && !worker.CancellationPending;\n        if (processingResult)\n        {\n            // Set the datasource of the grid\n            bindingSource.DataSource = controller.List;\n        }\n    }\n\n    // and inform the command we are done\n    OnDoneProcessing(EventArgs.Empty);\n}