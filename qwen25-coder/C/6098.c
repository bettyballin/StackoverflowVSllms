#include "FlashRuntimeExtensions.h"\n\nvoid myFunction(FREContext ctx, void* funcData, uint32_t argc, FREObject argv[]) {\n    // Your code here to use the DLL or any other native functionality\n}\n\nvoid contextInitializer(void* extData, const uint8_t* appName, uint32_t appVersion, void** outCtx) {\n    FREContext ctx = NULL;\n    FRECreateContext(NULL, NULL, &ctx);\n    \n    if (ctx != NULL && extData != NULL) {\n        *outCtx = extData;        \n    }\n}\n\nvoid contextFinalizer(FREContext ctx) {\n    // Cleanup when the extension is loaded\n}\n\nint32_t initializer(const uint8_t* appIdentifier, FREApplicationInit* resultInitializer) {\n    resultInitializer->initialize = &contextInitializer;\n    resultInitializer->finalize   = &contextFinalizer;\n\n    return FRE_NEW_EXTENSION_ERROR;\n    //return FREResultSuccess;\n}\n\nvoid finalizer(void) {}\n\nint main(int argc, char **argv[]) {\n    return 0;\n}