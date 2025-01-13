using System;\nusing System.Collections.Generic;\n\npublic class Broker\n{\n    public string Name = string.Empty;\n    public int Weight = 0;\n\n    public Broker(string n, int w)\n    {\n        this.Name = n;\n        this.Weight = w;\n    }\n}\n\nclass Program\n{\n    private static Random _rnd = new Random();\n\n    public static Broker GetBroker(List<Broker> brokers, int totalWeight)\n    {\n        // totalWeight is the sum of all brokers' weight\n        int randomNumber = _rnd.Next(0, totalWeight);\n\n        foreach (Broker broker in brokers)\n        {\n            if (randomNumber < broker.Weight)\n            {\n                return broker;\n            }\n            randomNumber -= broker.Weight;\n        }\n\n        return null; // This line should technically never be reached if the input is correct\n    }\n\n    static void Main(string[] args)\n    {\n        List<Broker> brokers = new List<Broker>\n        {\n            new Broker("A", 10),\n            new Broker("B", 20),\n            new Broker("C", 20),\n            new Broker("D", 10)\n        };\n\n        // Calculate the total weight\n        int totalWeight = 0;\n        foreach (Broker broker in brokers)\n        {\n            totalWeight += broker.Weight;\n        }\n\n        while (true)\n        {\n            Dictionary<string, int> result = new Dictionary<string, int>();\n\n            for (int i = 0; i < 1000; i++)\n            {\n                Broker selectedBroker = GetBroker(brokers, totalWeight);\n                if (selectedBroker != null)\n                {\n                    if (result.ContainsKey(selectedBroker.Name))\n                    {\n                        result[selectedBroker.Name] = result[selectedBroker.Name] + 1;\n                    }\n                    else\n                    {\n                        result.Add(selectedBroker.Name, 1);\n                    }\n                }\n            }\n\n            foreach (var kvp in result)\n            {\n                Console.WriteLine($"{kvp.Key}\t\t{kvp.Value}");\n            }\n\n            result.Clear();\n            Console.WriteLine();\n            Console.ReadLine();\n        }\n    }\n}