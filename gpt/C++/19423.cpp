_Application app;\nCOleVariant vtOpt(DISP_E_PARAMNOTFOUND, VT_ERROR),\n            vtTrue((short)TRUE),\n            vtFalse((short)FALSE);\napp.CreateDispatch("Word.Application", NULL);\nDocuments docs = app.GetDocuments();\n_Document doc = docs.Add(vtOpt, vtOpt, vtOpt, vtOpt);\n\n// Insert MathML as text\nCString mathML = _T("<math xmlns='http://www.w3.org/1998/Math/MathML'>...</math>");\nRange range = doc.Range(vtOpt, vtOpt);\nrange.InsertAfter(mathML);\n\n// Call the VBA macro to convert MathML to MathType\napp.Run(COleVariant(_T("ConvertMathMLToMathType")));