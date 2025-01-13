// MyDialogDLL.cpp\n#include "stdafx.h"\n#include "MyDialogDLL.h"\n#include "resource.h" // Include your resource header file\n\nclass CMyDialog : public CDialogEx\n{\npublic:\n    CMyDialog(CWnd* pParent = NULL) : CDialogEx(IDD_MY_DIALOG, pParent) {}\n\n    void ChangeButtonText()\n    {\n        CWnd* pButton = GetDlgItem(IDC_MY_BUTTON);\n        if (pButton)\n        {\n            pButton->SetWindowText(_T("New Text"));\n        }\n    }\n\nprotected:\n    virtual BOOL OnInitDialog()\n    {\n        CDialogEx::OnInitDialog();\n        ChangeButtonText();\n        return TRUE;\n    }\n};\n\nMYDIALOGDLL_API void ShowDialog()\n{\n    AFX_MANAGE_STATE(AfxGetStaticModuleState());\n\n    CMyDialog dlg;\n    dlg.DoModal();\n}