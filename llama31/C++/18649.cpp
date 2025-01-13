#include <functional>\n\nclass Action {\npublic:\n    void operator()() const;\n};\n\nclass Data {\npublic:\n    Data();\n    ~Data();\n    void Register(Action action) { _a = action; }\n\nprivate:\n    Action _a;\n};\n\nclass Display {\npublic:\n    Display(Data d) {\n        d.Register(std::bind(&Display::SomeTask, this, std::placeholders::_1));\n    }\n    ~Display();\n    void SomeTask();\n};