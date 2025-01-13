// Example setup for MAF (simplified)\npublic interface IExtensibleAddIn : IContract {\n    void Run();\n}\n\n[HostAdapterContract(Version="1.0")]\npublic interface IExtensibleAddInView : IContract {\n    object GetRootObject();\n}\n\nclass Program {\n    static void Main(string[] args) {\n        var domain = AddInStore.FindAddIns<IExtensibleAddInView>("Plugins", "1.0");\n        foreach (var app in domain) {\n            using (HostingEnvironment env = new HostingEnvironment(app)) {\n                var addin = ActivateViewInDefaultAppDomain(env, typeof(IExtensibleAddInView), null);\n                ((IExtensibleAddInView)addin).GetRootObject().Run();\n            }\n        }\n    }\n}