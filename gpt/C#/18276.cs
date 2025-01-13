using System;\nusing System.Reflection;\nusing System.Security.Policy;\n\nnamespace ZoneCheck\n{\n    class Program\n    {\n        static void Main(string[] args)\n        {\n            try\n            {\n                Console.WriteLine(".NET version: " + Environment.Version);\n\n                foreach (var evidence in Assembly.GetExecutingAssembly().Evidence)\n                {\n                    if (evidence is Zone zone)\n                    {\n                        Console.WriteLine("Security zone: " + zone.SecurityZone);\n                        break;\n                    }\n                }\n            }\n            catch (Exception ex)\n            {\n                Console.WriteLine("An error occurred: " + ex.Message);\n            }\n        }\n    }\n}