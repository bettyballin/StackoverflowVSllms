#include <iostream>\n\n// Template class with a member function to perform some operation\ntemplate<typename T>\nclass Processor {\npublic:\n    void process() {\n        std::cout << "Processing with type: " << typeid(T).name() << std::endl;\n    }\n};\n\n// Base class for runtime selection\nclass RuntimeProcessor {\npublic:\n    virtual ~RuntimeProcessor() = default;\n    virtual void process() = 0;\n};\n\n// Derived classes for each type\nclass FloatProcessor : public RuntimeProcessor {\npublic:\n    void process() override {\n        Processor<float> p;\n        p.process();\n    }\n};\n\nclass DoubleProcessor : public RuntimeProcessor {\npublic:\n    void process() override {\n        Processor<double> p;\n        p.process();\n    }\n};\n\nint main() {\n    int choice;\n    std::cout << "Enter 1 for float, 2 for double: ";\n    std::cin >> choice;\n\n    std::unique_ptr<RuntimeProcessor> processor;\n    if (choice == 1) {\n        processor = std::make_unique<FloatProcessor>();\n    } else if (choice == 2) {\n        processor = std::make_unique<DoubleProcessor>();\n    } else {\n        std::cerr << "Invalid choice" << std::endl;\n        return 1;\n    }\n\n    processor->process();\n    return 0;\n}