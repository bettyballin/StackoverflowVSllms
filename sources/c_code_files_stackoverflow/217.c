#include <windows.h>
#include <oleauto.h>

int main() {
    ITypeLib *ptlib;
    HRESULT hr = LoadTypeLib("sql.tlb", &ptlib);
    if (FAILED(hr)) {
        printf("Failed to load type library: 0x%x\n", hr);
        return 1;
    }
    // You should release the type library when you're done with it
    ptlib->lpVtbl->Release(ptlib);
    return 0;
}