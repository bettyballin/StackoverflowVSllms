pp
#include <afxwin.h>
#include <afxext.h>
#include <afxhtml.h>

class CMyHTMLDlg : public CDHtmlDialog
{
public:
    DECLARE_MESSAGE_MAP()
    DECLARE_EVENTSINK_MAP()

    void OnBeforeNavigate2(LPDISPATCH pDisp, VARIANT* URL, VARIANT* Flags, VARIANT* TargetFrameName, VARIANT* PostData, VARIANT* Headers, BOOL* Cancel);
};

BEGIN_EVENTSINK_MAP(CMyHTMLDlg, CDHtmlDialog)
    ON_EVENT(CMyHTMLDlg, AFX_IDC_BROWSER, DISPID_BEFORENAVIGATE2, OnBeforeNavigate2, VTS_DISPATCH VTS_VARIANT VTS_VARIANT VTS_VARIANT VTS_VARIANT VTS_VARIANT VTS_PBOOL)
END_EVENTSINK_MAP()

void CMyHTMLDlg::OnBeforeNavigate2(LPDISPATCH pDisp, VARIANT* URL, VARIANT* Flags, VARIANT* TargetFrameName, VARIANT* PostData, VARIANT* Headers, BOOL* Cancel)
{
    if (URL != NULL)
    {
        // Check if navigation is to a folder..
        CString url = CString(*URL);

        if(url.Left(11) != _T("javascript:"))
        {
            _OnBeforeNavigate2(pDisp, URL, Flags, TargetFrameName, PostData, Headers, (BOOL*)Cancel);
            // If dynamic linking MFC then the above handler doesn't exist. Need to call OnBeforeNavigate direct. 
            // This is from a code site, and it compiles, but I've never tested it to see if it works.
            //CDHtmlDialog::OnBeforeNavigate(pDisp,(LPCSTR)URL);
        }
    }
}

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow)
{
    // Initialize MFC and print and error on failure
    if (!AfxWinInit(hInstance, hPrevInstance, lpCmdLine, nCmdShow))
    {
        MessageBox(NULL, _T("MFC initialization failed"), _T("Fatal Error"), MB_ICONERROR);
        return 1;
    }

    // Create an instance of the dialog
    CMyHTMLDlg dlg;
    dlg.DoModal();

    // Terminate the MFC framework
    AfxWinTerm();
    return 0;
}