#include <list>\n#include <stdexcept>\n\ntemplate <class T>\nclass myList : public std::list<T> {\npublic:\n    T& operator[](int index);\n    const T& operator[](int index) const;\n    myList() = default;\n    ~myList() = default;\n};\n\n// Include the implementation of the template class in the header file\n\ntemplate<class T>\nT& myList<T>::operator[](int index) {\n    if (index < 0 || index >= this->size()) {\n        throw std::out_of_range("Index out of range");\n    }\n    auto itr = this->begin();\n    std::advance(itr, index);\n    return *itr;\n}\n\ntemplate<class T>\nconst T& myList<T>::operator[](int index) const {\n    if (index < 0 || index >= this->size()) {\n        throw std::out_of_range("Index out of range");\n    }\n    auto itr = this->cbegin();\n    std::advance(itr, index);\n    return *itr;\n}