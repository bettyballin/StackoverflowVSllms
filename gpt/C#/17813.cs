// Wrapper.cs\nusing MyClassLibrary;\n\nnamespace MyWrapperLibrary\n{\n    public class Wrapper\n    {\n        public void Send(ClassLib classLib)\n        {\n            // Add additional functionality here\n            Console.WriteLine($"ID: {classLib.Id}, Name: {classLib.Name}");\n        }\n    }\n}