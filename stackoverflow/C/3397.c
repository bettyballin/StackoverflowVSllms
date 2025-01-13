node* tortoise(begin), * hare(begin);\nwhile(hare = hare->next)\n{\n    if(hare == tortoise) { throw std::logic_error("There's a cycle"); }\n    hare = hare->next;\n    if(hare == tortoise) { throw std::logic_error("There's a cycle"); }\n    tortoise = tortoise->next;\n}