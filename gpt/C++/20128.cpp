CComPtr<IHTMLDocument2> spDocument;  // This is your document pointer\nIStream* pStream = nullptr;\n\n// Marshal the interface pointer to a stream\nHRESULT hr = CoMarshalInterThreadInterfaceInStream(IID_IHTMLDocument2, spDocument, &pStream);\nif (FAILED(hr)) {\n    // Handle the error\n}