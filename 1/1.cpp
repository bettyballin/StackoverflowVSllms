#include <atlbase.h>
#include <atlcom.h>
#include <mshtml.h>

class CHelloWorldBHO : 
    public IDispEventImpl<2, CHelloWorldBHO, &DIID_HTMLTextContainerEvents2, &LIBID_MSHTML, 4, 0>
{
public:
    BEGIN_SINK_MAP(CHelloWorldBHO)
        SINK_ENTRY_EX(2, DIID_HTMLTextContainerEvents2, DISPID_HTMLTEXTCONTAINEREVENTS2_ONCLICK, OnClick)
    END_SINK_MAP()

    HRESULT OnClick(IHTMLEventObj* pEvtObj)
    {
        // Your implementation here
        return S_OK;
    }
};