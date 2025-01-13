using System;\nusing System.Threading;\nusing System.Threading.Tasks;\n\nclass MyConsoleProgram\n{\n    private static CancellationTokenSource _cancellationTokenSource;\n    private static Task _monitoringTask;\n\n    public static event Action OnExit;\n\n    static void Main(string[] args)\n    {\n        _cancellationTokenSource = new CancellationTokenSource();\n        CancellationToken cancellationToken = _cancellationTokenSource.Token;\n\n        // Start your monitoring task or tasks here\n        _monitoringTask = Task.Run(() => MonitorCondition(cancellationToken));\n\n        // Handle application exit and cancellation\n        AppDomain.CurrentDomain.ProcessExit += OnProcessExit;\n        Console.CancelKeyPress += OnCancelKeyPress;\n\n        // Keep the main thread alive to allow for cancellation\n        Console.WriteLine("Press Ctrl+C to exit...");\n        Console.ReadKey();\n    }\n\n    private static async Task MonitorCondition(CancellationToken cancellationToken)\n    {\n        while (!cancellationToken.IsCancellationRequested)\n        {\n            // Your monitoring logic goes here\n            await Task.Delay(1000, cancellationToken);\n        }\n    }\n\n    private static void OnProcessExit(object sender, EventArgs e)\n    {\n        PerformCleanup();\n    }\n\n    private static void OnCancelKeyPress(object sender, ConsoleCancelEventArgs e)\n    {\n        e.Cancel = true; // Prevent the application from terminating immediately\n        PerformCleanup();\n    }\n\n    private static void PerformCleanup()\n    {\n        _cancellationTokenSource?.Cancel();\n\n        // Optionally wait for tasks to complete or timeout\n        try\n        {\n            Task.WaitAll(_monitoringTask, TimeSpan.FromSeconds(5));\n        }\n        catch (AggregateException)\n        {\n            // Handle exceptions if some tasks did not complete within the timeout.\n        }\n\n        OnExit?.Invoke();\n        Console.WriteLine("Cleanup complete. Exiting...");\n    }\n}