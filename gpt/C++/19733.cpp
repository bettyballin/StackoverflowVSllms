#pragma once\n\n#include "UnmanagedClass.h"\n\nusing namespace System;\n\nnamespace ManagedNamespace {\n    public ref class ManagedClass {\n    private:\n        UnmanagedClass* pUnmanaged;\n\n    public:\n        ManagedClass() {\n            pUnmanaged = new UnmanagedClass();\n        }\n\n        ~ManagedClass() {\n            this->!ManagedClass();\n        }\n\n        !ManagedClass() {\n            delete pUnmanaged;\n        }\n\n        void DoSomething() {\n            pUnmanaged->DoSomething();\n        }\n    };\n}