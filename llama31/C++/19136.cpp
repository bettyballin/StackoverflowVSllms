struct Visitor \n{\n    template <typename T>\n    void operator()(T t)\n    {\n        // primary template\n    }\n};\n\ntemplate <>\nvoid Visitor::operator()(bool b)\n{\n    // template specialization\n}