using System;\nusing System.IO;\nusing System.Threading;\n\nclass Program\n{\n    private const string MutexName = "Global\\MyNamedMutex";\n    private const string OwnerFilePath = "mutex_owner.txt";\n\n    static void Main(string[] args)\n    {\n        Mutex mutex = new Mutex(false, MutexName);\n        try\n        {\n            if (mutex.WaitOne(TimeSpan.FromSeconds(5), false))\n            {\n                try\n                {\n                    string ownerName = "ApplicationName"; // Replace with actual application name or identifier\n                    File.WriteAllText(OwnerFilePath, ownerName);\n                    Console.WriteLine("Mutex acquired by: " + ownerName);\n                    Console.WriteLine("Press Enter to release the mutex.");\n                    Console.ReadLine();\n                }\n                finally\n                {\n                    mutex.ReleaseMutex();\n                    File.Delete(OwnerFilePath);\n                }\n            }\n            else\n            {\n                Console.WriteLine("Mutex is already acquired by: " + GetMutexOwner());\n            }\n        }\n        catch (AbandonedMutexException)\n        {\n            Console.WriteLine("Mutex was abandoned. Acquiring and setting as owner.");\n            // Handle abandoned mutex\n        }\n    }\n\n    private static string GetMutexOwner()\n    {\n        if (File.Exists(OwnerFilePath))\n        {\n            return File.ReadAllText(OwnerFilePath);\n        }\n        return "Unknown";\n    }\n}