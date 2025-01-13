#include <boost/spirit/include/qi.hpp>\n#include <iostream>\n#include <string>\n\nnamespace qi = boost::spirit::qi;\nusing namespace std;\n\ndouble calculate(const string& input) {\n    double result = 0.0;\n    auto iter_begin = input.begin();\n    auto iter_end   = input.end();\n\n    // Define and parse the grammar\n    bool success = qi::phrase_parse(\n        iter_begin,           // start iterator\n        iter_end,             // end iterator\n        (\n            (qi::double_ >> qi::lit('+') >> qi::double_)[qi::_val = qi::_1 + qi::_3] |\n            (qi::double_ >> qi::lit('-') >> qi::double_)[qi::_val = qi::_1 - qi::_3] |\n            (qi::double_ >> qi::lit('*') >> qi::double_)[qi::_val = qi::_1 * qi::_3] |\n            (qi::double_ >> qi::lit('/') >> qi::double_)[qi::_val = qi::_1 / qi::_3]\n        ),\n        qi::space,             // skip whitespace\n        result                 // return value\n    );\n\n    if (!success || iter_begin != iter_end) {\n        cout << "Parsing failed\n";\n        return 0;\n    }\n\n    return result;\n}\n\nint main() {\n    string expression = "3.5 + 4 * 2 - 8 / 1";\n    double value = calculate(expression);\n    cout << "Result: " << value << '\n'; // Should output: Result: 9\n    return 0;\n}