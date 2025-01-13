template <typename MC, typename MT>\nclass Manager : public Factory<MC, MT>\n{\npublic:\n    bool RegisterType(const MT Type, const std::string TypeName)\n    {\n        // Using 'this->' to specify that we are referring to a base class member function\n        return this->Register<MC>(Type);\n        \n        // Alternatively, you can use:\n        // return Factory<MC, MT>::template Register<MC>(Type);\n    }\n};