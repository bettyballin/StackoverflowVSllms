template<typename T>\nvector<T> readVector(ifstream &in)\n{\n    size_t size;\n    if (!(in >> size)) {\n        // If the file is empty, return an empty vector\n        return vector<T>();\n    }\n\n    vector<T> vec;\n    vec.reserve(size);\n\n    for(unsigned int i = 0; i < size; i++)\n    {\n        T tmp;\n        in >> tmp;\n        vec.push_back(tmp);\n    }\n\n    return vec;\n}