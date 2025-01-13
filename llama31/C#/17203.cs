public class CreatingClass\n{\n    public T CreateObject<T>(Dictionary<string, object> parameters) where T : IMyInterface, new()\n    {\n        // ...\n    }\n\n    public void DestroyObject(IMyInterface objectToDestroy)\n    {\n        // Perform any necessary cleanup or disposal\n        // ...\n    }\n}\n\npublic class ClientClass\n{\n    MyObject obj;\n    CreatingClass creatingClass = new CreatingClass();\n\n    private void AFunctionToCreateMyClass()\n    {\n        obj = creatingClass.CreateObject<MyClass>(parameters);\n    }\n\n    private void AFunctionToDeleteMyObject()\n    {\n        creatingClass.DestroyObject(obj);\n        obj = null; // Set the original reference to null\n        Assert.IsNull(obj); // Should pass\n    }\n}