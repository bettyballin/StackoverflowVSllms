#include <windows.h>
#include <oaidl.h>
#include <exdisp.h>

#define TOOLBAR_GUID "{TOOLBAR-GUID}"

class MyBHO : public IObjectWithSite
{
public:
    STDMETHODIMP SetSite(IUnknown *pUnkSite)
    {
        if( /*is this the first run since BHO was installed?*/ )
        {
            CComQIPtr<IWebBrowser2, &IID_IWebBrowser2> webBrowser2 = pUnkSite; 
            if( webBrowser2 != NULL )
            {
                VARIANT vtBandGUID, vtShow, vtSize;

                vtBandGUID.vt = VT_BSTR;
                vtBandGUID.bstrVal = SysAllocString( OLESTR( TOOLBAR_GUID ) );

                vtShow.vt = VT_BOOL;
                vtShow.boolVal = true;

                vtSize.vt = VT_I2;
                vtSize.iVal = 0;

                webBrowser2->ShowBrowserBar( &vtBandGUID, &vtShow, &vtSize );
                SysFreeString( vtBandGUID.bstrVal );
            }
        }

        return S_OK;
    }

    // Other IObjectWithSite methods
    STDMETHODIMP GetSite(REFIID riid, void **ppvSite)
    {
        return E_NOTIMPL;
    }
};

// Class factory for MyBHO
class MyBHOCF : public IClassFactory
{
public:
    STDMETHODIMP CreateInstance(IUnknown *pUnkOuter, REFIID riid, void **ppvObject)
    {
        MyBHO *pBHO = new MyBHO;
        if (pBHO == NULL)
            return E_OUTOFMEMORY;

        HRESULT hr = pBHO->QueryInterface(riid, ppvObject);
        if (FAILED(hr))
        {
            delete pBHO;
            return hr;
        }

        return S_OK;
    }

    STDMETHODIMP LockServer(BOOL fLock)
    {
        return S_OK;
    }
};

// DLL entry points
STDAPI DllGetClassObject(REFCLSID rclsid, REFIID riid, LPVOID *ppv)
{
    if (rclsid == IID_MyBHO)
    {
        MyBHOCF *pCF = new MyBHOCF;
        if (pCF == NULL)
            return E_OUTOFMEMORY;

        HRESULT hr = pCF->QueryInterface(riid, ppv);
        if (FAILED(hr))
        {
            delete pCF;
            return hr;
        }

        return S_OK;
    }

    return CLASS_E_CLASSNOTAVAILABLE;
}

STDAPI DllRegisterServer(void)
{
    // Register the BHO
    return S_OK;
}

STDAPI DllUnregisterServer(void)
{
    // Unregister the BHO
    return S_OK;
}

STDAPI DllCanUnloadNow(void)
{
    // Allow the DLL to be unloaded
    return S_OK;
}