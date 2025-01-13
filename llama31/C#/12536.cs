[COMImport]\n[Guid("your-guid-here")]\n[InterfaceType(ComInterfaceType.InterfaceIsIDispatch)]\npublic interface IYourComInterface\n{\n    [DispId(1)]\n    void Process(param1, param2, param3, param4);\n}\n\n// ...\n\ntry\n{\n    IYourComInterface comInterface = (IYourComInterface)f_oInstance;\n    comInterface.Process(param1, param2, param3, param4);\n}\ncatch (COMException ex)\n{\n    int errorCode = ex.ErrorCode;\n    // Log or handle the error code\n}