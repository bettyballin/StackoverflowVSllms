private:\n    CComPtr<IRawPdu>* getRawPdu();\n    // Returns a pointer to the RawPdu interface pointer from the mRawPdu data member.\n    // mRawPdu is initialized, if necessary.\n\n    CComPtr<IRawPdu> mRawPdu;\n    // Initialized to 0 in the ctor.  Uses lazy evaluation via getRawPdu().