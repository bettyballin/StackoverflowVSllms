pp
#include <Windows.h>
#include <objbase.h>

template <typename interface_t>
void update(interface_t* p, HRESULT (__stdcall interface_t::*com_uint_getter)(UINT*), UINT& u)
{
    UINT tmp;
    if (S_OK == (p->*com_uint_getter)(&tmp)) {
        u = tmp;
    }
}

int main(int, char*[])
{
    // Initialize COM library
    CoInitialize(nullptr);

    // I choose IDispatch::GetTypeInfoCount just for the sake of exemplification
    IDispatch* ptr = nullptr;
    CoCreateInstance(CLSID_StdDispatch, nullptr, CLSCTX_INPROC_SERVER, IID_PPV_ARGS(&ptr));
    UINT u;
    update(ptr, &IDispatch::GetTypeInfoCount, u);

    // Release COM resources
    if (ptr) {
        ptr->Release();
    }
    CoUninitialize();

    return 0;
}