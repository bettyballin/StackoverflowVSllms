pp
#include <windows.h>
#include <objbase.h>

// Define the interface and its methods
interface IMyInterface : public IUnknown
{
    STDMETHOD(MethodIReallyNeed)() = 0;
};

int main()
{
    CoInitialize(NULL); // Initialize the COM subsystem

    IMyInterface* pIFace = NULL;
    HRESULT hr = CoCreateInstance(CLSID_MyObject, NULL, CLSCTX_ALL, IID_IMyInterface, (void**)&pIFace);

    if (SUCCEEDED(hr))
    {
        pIFace->MethodIReallyNeed(); // Use the object
        pIFace->Release(); // Free the object
    }

    CoUninitialize(); // Cleanup COM after you're done using its services

    return 0;
}