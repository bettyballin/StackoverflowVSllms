++
#include <afxwin.h>
#include <afxribbon.h>

// Define your own ID for the label
#define ID_MYLABEL 1000

class CMyFrame : public CFrameWnd
{
public:
    CMyFrame()
    {
        // Initialize the status bar
        if (!m_wndStatusBar.Create(this))
        {
            TRACE0("Failed to create status bar\n");
            return;
        }
        m_wndStatusBar.SetIndicators(NULL, 0); // No indicators for this example
        RepositionBars(AFX_IDW_CONTROLBAR_FIRST, AFX_IDW_CONTROLBAR_LAST, IDW_STATUS_BAR);

        // Create and add a dynamic label to the status bar
        CMFCRibbonLabel* pLabel = new CMFCRibbonLabel(_T("My Label"));
        pLabel->SetID(ID_MYLABEL); // Set the ID for the label
        m_wndStatusBar.AddDynamicElement(pLabel);
        m_wndStatusBar.RecalcLayout();
        m_wndStatusBar.RedrawWindow();
    }

    // Destructor
    ~CMyFrame()
    {
    }

    // Member variables
    CStatusBar m_wndStatusBar;
};

class CMyApp : public CWinApp
{
public:
    virtual BOOL InitInstance()
    {
        // Create a new frame
        CMyFrame* pFrame = new CMyFrame();
        m_pMainWnd = pFrame;

        // Show the frame
        pFrame->ShowWindow(SW_SHOW);
        pFrame->UpdateWindow();

        return TRUE;
    }
};

// The one and only application object
CMyApp theApp;