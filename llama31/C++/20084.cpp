// COM example (simplified)\n#import "legacy_system.tlb"\n\nclass MyComComponent : public IUnknown {\npublic:\n    // COM interface methods\n    HRESULT __stdcall DoSomething() {\n        // Call legacy system API\n        legacy_system::DoSomething();\n        return S_OK;\n    }\n};\n\n// WCF example (simplified)\n[ServiceContract]\npublic interface IMyService {\n    [OperationContract]\n    void DoSomething();\n}\n\npublic class MyService : IMyService {\n    public void DoSomething() {\n        // Create COM component instance\n        MyComComponent* comComponent = new MyComComponent();\n        comComponent->DoSomething();\n    }\n}