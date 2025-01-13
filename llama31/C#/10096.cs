using System;\nusing System.Runtime.InteropServices;\n\npublic class ComObjectFinalizer\n{\n    public static void DumpFinalizationQueue()\n    {\n        Console.WriteLine("Finalization Queue:");\n        var finalizationQueue = GC.GetFinalizationQueue();\n        foreach (var obj in finalizationQueue)\n        {\n            Console.WriteLine($"  {obj.GetType().Name}");\n        }\n    }\n\n    public static void DumpHeapObjects()\n    {\n        Console.WriteLine("Heap Objects:");\n        var heapObjects = GC.GetHeapObjects();\n        foreach (var obj in heapObjects)\n        {\n            Console.WriteLine($"  {obj.GetType().Name}");\n        }\n    }\n}