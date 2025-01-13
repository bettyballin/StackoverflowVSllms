#include <jni.h>\n   #include <windows.h>\n   #include <ocidl.h>\n   #include <olectl.h>\n   \n   JNIEXPORT void JNICALL Java_ActiveXHost_createActiveXControl(JNIEnv *env, jobject obj, jlong hwnd) {\n       HWND parentHwnd = (HWND) hwnd;\n       \n       // Initialize COM\n       CoInitialize(NULL);\n       \n       // Create and host the ActiveX control\n       CLSID clsid;\n       IUnknown *pUnknown;\n       IOleObject *pOleObject;\n       \n       // The CLSID of the ActiveX control (example for Flash)\n       CLSIDFromProgID(L"ShockwaveFlash.ShockwaveFlash", &clsid);\n       \n       // Create the instance\n       CoCreateInstance(clsid, NULL, CLSCTX_INPROC_SERVER, IID_IUnknown, (void**)&pUnknown);\n       \n       // Query for IOleObject\n       pUnknown->QueryInterface(IID_IOleObject, (void**)&pOleObject);\n       \n       // Set the parent window\n       pOleObject->DoVerb(OLEIVERB_INPLACEACTIVATE, NULL, NULL, 0, parentHwnd, NULL);\n       \n       // Clean up\n       pUnknown->Release();\n       pOleObject->Release();\n       CoUninitialize();\n   }