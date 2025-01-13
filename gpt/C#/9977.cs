using System;\n\npublic class MyClass<T> where T : Attribute\n{\n    public void DisplayAttributeInfo()\n    {\n        // Create an instance of T\n        T attribute = Activator.CreateInstance<T>();\n\n        // Display the type of the attribute\n        Console.WriteLine("Attribute type: " + attribute.GetType().Name);\n    }\n}\n\n// Example usage\npublic class MyCustomAttribute : Attribute\n{\n}\n\nclass Program\n{\n    static void Main()\n    {\n        MyClass<MyCustomAttribute> myClassInstance = new MyClass<MyCustomAttribute>();\n        myClassInstance.DisplayAttributeInfo(); // Output: Attribute type: MyCustomAttribute\n    }\n}