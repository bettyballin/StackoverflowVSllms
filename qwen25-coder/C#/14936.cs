using System;\nusing System.Threading.Tasks;\n\npublic class MyDllClass\n{\n    public async Task LongProcessAsync()\n    {\n        for (int i = 0; i < 100; i++)\n        {\n            // Perform some processing here\n\n            // Allow other events to be processed, similar to DoEvents\n            await Task.Delay(0);\n        }\n    }\n}