if (mMC)\n{\n    hr = mMC->Stop();\n    if (FAILED(hr))\n    {\n        return hr;\n    }\n}\n\nif (mME)\n{\n    mME->Release();\n    mME = NULL;\n}