class BaseA\n{\npublic:\n    virtual int foo() = 0;\n};\n\nclass BaseB\n{\npublic:\n    virtual int foo() { return 42; }\n};\n\nclass BaseC\n{\npublic:\n    int foo() { return 42; }\n};\n\nclass ChildA : public BaseA\n{\npublic:\n    int foo() override { return 42; }\n};\n\nclass ChildB : public BaseB\n{\npublic:\n    int foo() override { return 42; }\n};\n\nclass ChildC : public BaseC\n{\npublic:\n    int foo() { return 42; }\n};