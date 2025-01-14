pp
#include <iostream>

// A simple implementation of the CComObject class
template <class T>
class CComObject {
public:
    T* operator->() { return &obj_; }
    void AddRef() { std::cout << "AddRef called." << std::endl; }

private:
    T obj_;
};

// A simple implementation of the CNumber class
class CNumber {
public:
    // You would need to implement the necessary methods here...
};

int main() {
    CNumber** pVal = new CNumber*;
    *pVal = new CComObject<CNumber>();
    (*pVal)->AddRef();
    delete *pVal;
    delete pVal;
    return 0;
}