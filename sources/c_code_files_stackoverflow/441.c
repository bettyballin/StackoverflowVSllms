#include <windows.h>
#include <ole2.h>

int main() {
  BSTR bstrTLBNameWithPath = SysAllocString(L""); // set this to whatever you want

  if (bstrTLBNameWithPath) {
    ITypeLib *pTlib = 0;
    HRESULT hr = LoadTypeLib(bstrTLBNameWithPath, &pTlib);
    if (SUCCEEDED(hr) && pTlib) {
      TLIBATTR *pTlibattr = 0;
      hr = pTlib->GetLibAttr(&pTlibattr);
      if (SUCCEEDED(hr) && pTlibattr) {
        // do something with the info

        // release the information
        pTlib->ReleaseTLibAttr(pTlibattr);
        pTlib->Release();
      }
    }
    SysFreeString(bstrTLBNameWithPath);
  }
  return 0;
}