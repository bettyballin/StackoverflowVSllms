std::list<item*>::iterator i = items.begin();\nwhile (i != items.end())\n{\n    bool isActive = (*i)->update();\n    if (!isActive)\n    {\n        i = items.erase(i);  // Use the return value of erase\n    }\n    else\n    {\n        other_code_involving(*i);\n        ++i;\n    }\n}