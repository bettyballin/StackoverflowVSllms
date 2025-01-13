using System;\nusing System.Collections.Generic;\nusing System.Reflection;\n\nclass Car\n{\n    // Car class implementation\n}\n\nclass Other\n{\n    public List<T> GetAll<T>()\n    {\n        // Method to return a list of T from the database\n        return new List<T>(); // Placeholder code\n    }\n}\n\nclass Program\n{\n    static void Main()\n    {\n        Type t = typeof(Car);\n        Other other = new Other();\n\n        MethodInfo methodInfo = typeof(Other).GetMethod("GetAll");\n        MethodInfo genericMethod = methodInfo.MakeGenericMethod(t);\n\n        var cars = (List<Car>)genericMethod.Invoke(other, null);\n\n        // Use the cars list\n    }\n}