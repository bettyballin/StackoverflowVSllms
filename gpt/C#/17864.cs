using System;\nusing System.Collections.Concurrent;\nusing System.Data.SqlClient;\nusing System.Threading;\nusing System.Threading.Tasks;\n\nclass Program\n{\n    static BlockingCollection<int> newCustomerQueue = new BlockingCollection<int>();\n\n    static void Main()\n    {\n        Task.Factory.StartNew(ProcessNewCustomers);\n        Task.Factory.StartNew(ProcessHourlyUpdates);\n\n        // Simulate adding new customers to the queue\n        newCustomerQueue.Add(123);\n        newCustomerQueue.Add(456);\n    }\n\n    static void ProcessNewCustomers()\n    {\n        foreach (var customerId in newCustomerQueue.GetConsumingEnumerable())\n        {\n            if (!IsCustomerBeingUpdated(customerId))\n            {\n                // Perform real-time processing for the new customer\n                UpdateCustomerData(customerId);\n            }\n        }\n    }\n\n    static void ProcessHourlyUpdates()\n    {\n        var customers = GetCustomersToUpdate();\n        var partitioner = Partitioner.Create(customers);\n\n        Parallel.ForEach(partitioner, new ParallelOptions { MaxDegreeOfParallelism = 4 }, customer =>\n        {\n            if (!IsCustomerBeingUpdated(customer))\n            {\n                UpdateCustomerData(customer);\n            }\n        });\n    }\n\n    static ConcurrentBag<int> GetCustomersToUpdate()\n    {\n        var customers = new ConcurrentBag<int>();\n        // Fetch customer IDs to update from the database\n        return customers;\n    }\n\n    static void UpdateCustomerData(int customerId)\n    {\n        // Perform update operation for the customer\n    }\n\n    static bool IsCustomerBeingUpdated(int customerId)\n    {\n        // Check if the customer is currently being updated by another process\n        // This could be implemented using a flag in the database\n        return false;\n    }\n}