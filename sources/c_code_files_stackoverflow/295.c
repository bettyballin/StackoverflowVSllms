pp
#include <windows.h>

// Define the STDMETHOD and STDMETHOD_ macros if they're not already defined
#ifndef STDMETHOD
#define STDMETHOD(method) virtual HRESULT STDMETHODCALLTYPE method
#endif

#ifndef STDMETHOD_
#define STDMETHOD_(type, method) virtual type STDMETHODCALLTYPE method
#endif

#ifndef PURE
#define PURE = 0
#endif

#ifndef THIS_
#define THIS_ 
#endif

#ifndef THIS
#define THIS THIS_
#endif

// Define the interface
interface IExportedMethods {
    STDMETHOD_(long, AMethod)(THIS) PURE;
};

int main() {
    // You can add your implementation here
    return 0;
}