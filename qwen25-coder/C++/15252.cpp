class B : public A\n{\npublic:\n    using A::DoSomething; // Bring base class DoSomething into scope of class B\n    int DoSomething(int x) { return 1; };\n};