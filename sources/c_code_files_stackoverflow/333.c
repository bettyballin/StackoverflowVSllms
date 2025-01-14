#include <atlbase.h>
#include <atlcom.h>
#include <mshtml.h>

class CMyClass : public IDispEventImpl<2, CMyClass, &DIID_HTMLElementEvents2, &LIBID_MSHTML, 4, 0>
{
public:
    void ConnectEvents(IHTMLElement* pElem)
    {
        DispEventAdvise(pElem);
    }
};