#include <jni.h>\n#include "OSInfo.h"\n#include <stdio.h>\n\n#ifdef _WIN32\n#include <Windows.h>\n#else\n#include <unistd.h>\n#include <sys/utsname.h>\n#endif\n\nJNIEXPORT jstring JNICALL Java_OSInfo_getOSName(JNIEnv *env, jobject obj) {\n    char osName[256];\n\n#ifdef _WIN32\n    OSVERSIONINFO verInfo;\n    verInfo.dwOSVersionInfoSize = sizeof(OSVERSIONINFO);\n    GetVersionEx(&verInfo);\n\n    sprintf(osName, "Windows %d.%d", verInfo.dwMajorVersion, verInfo.dwMinorVersion);\n#else\n    struct utsname name;\n    uname(&name);\n    snprintf(osName, sizeof(osName), "%s %s", name.sysname, name.release);\n#endif\n\n    return (*env)->NewStringUTF(env, osName);\n}