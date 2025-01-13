#include <afxdb.h> // MFC Database classes\n\nvoid ExecuteMultipleQueries(CDatabase& oDatabase, const CString& sQuery) {\n    // Split the query string by semicolon\n    int start = 0;\n    int end = sQuery.Find(';', start);\n    while (end != -1) {\n        CString singleQuery = sQuery.Mid(start, end - start).Trim();\n        if (!singleQuery.IsEmpty()) {\n            try {\n                oDatabase.ExecuteSQL(singleQuery);\n            } catch (CDBException* e) {\n                AfxMessageBox(e->m_strError);\n                e->Delete();\n            }\n        }\n        start = end + 1;\n        end = sQuery.Find(';', start);\n    }\n    // Execute the last part if there's any remaining query\n    CString lastQuery = sQuery.Mid(start).Trim();\n    if (!lastQuery.IsEmpty()) {\n        try {\n            oDatabase.ExecuteSQL(lastQuery);\n        } catch (CDBException* e) {\n            AfxMessageBox(e->m_strError);\n            e->Delete();\n        }\n    }\n}\n\nvoid CreateTables(CDatabase& oDatabase) {\n    CString sQuery = _T("CREATE TABLE [Table1] (ID AUTOINCREMENT, PRIMARY KEY ([ID])); "\n                        "CREATE TABLE [Table2] (ID AUTOINCREMENT, PRIMARY KEY ([ID]));");\n\n    ExecuteMultipleQueries(oDatabase, sQuery);\n}