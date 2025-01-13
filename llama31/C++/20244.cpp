template <typename T>\nclass SmartPtr\n{\npublic:\n    SmartPtr(T* p) : ptr_(p) {}\n    ~SmartPtr() { delete ptr_; ptr_ = NULL; }\n\n    T* operator->() { return ptr_; }\n    T& operator*() { return *ptr_; }\n\nprivate:\n    T* ptr_;\n};