public class RemotingService : MarshalByRefObject\n{\n    public async Task<string> LongRunningOperationAsync()\n    {\n        // Simulate a long-running operation\n        await Task.Delay(4000);\n        return "Operation Completed";\n    }\n}