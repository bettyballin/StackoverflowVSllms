public class BaseClass\n{\n    public virtual void VirtualMethod()\n    {\n        Console.WriteLine("BaseClass implementation.");\n    }\n}\n\npublic class DerivedClass : BaseClass\n{\n    public override void VirtualMethod()\n    {\n        Console.WriteLine("DerivedClass implementation.");\n    }\n}