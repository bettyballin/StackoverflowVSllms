#include <atlbase.h>\n#import "C:\\Program Files\\Common Files\\microsoft shared\\OFFICE12\\MSOUTL.OLB" no_namespace\n\nvoid SearchOutlookContacts(const std::wstring& searchText) {\n    CComPtr<Application> pApplication;\n    HRESULT hr = pApplication.CoCreateInstance(CLSID_Application);\n    if (FAILED(hr)) {\n        // Handle error\n        return;\n    }\n\n    CComPtr<NameSpace> pNamespace;\n    hr = pApplication->GetSession(&pNamespace);\n    if (FAILED(hr)) {\n        // Handle error\n        return;\n    }\n\n    CComVariant defaultStore(false);  // Use false for default store\n    CComVariant type(olFolderContacts);\n    CComPtr<MAPIFolder> pContactsFolder;\n    hr = pNamespace->GetDefaultFolder(type, &pItems);\n    if (FAILED(hr)) {\n        // Handle error\n        return;\n    }\n\n    CComPtr<Items> pItems;\n    hr = pContactsFolder->GetItems(&pItems);\n    if (FAILED(hr)) {\n        // Handle error\n        return;\n    }\n\n    _bstr_t filter = "Subject LIKE '%";\n    filter += searchText.c_str();\n    filter += "%'";\n    \n    CComPtr<Items> pFilteredItems;\n    hr = pItems->Restrict(filter, &pFilteredItems);\n    if (FAILED(hr)) {\n        // Handle error\n        return;\n    }\n\n    long count;\n    hr = pFilteredItems->GetCount(&count);\n    if (SUCCEEDED(hr) && count > 0) {\n        CComVariant index;\n        for (long i = 1; i <= count; ++i) {\n            index.vt = VT_I4;\n            index.lVal = i;\n\n            CComPtr<ContactItem> pContact;\n            hr = pFilteredItems->GetItem(index, (IDispatch**)&pContact);\n            if (SUCCEEDED(hr)) {\n                _bstr_t name, email;\n                pContact->get_FullName(&name);\n                pContact->get_Email1Address(&email);\n\n                // Output or process the contact information\n                wprintf(L"Name: %s, Email: %s\n", name, email);\n            }\n        }\n    } else {\n        wprintf(L"No contacts found matching '%s'\n", searchText.c_str());\n    }\n}