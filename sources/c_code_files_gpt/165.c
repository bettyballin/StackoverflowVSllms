#include <jni.h>
#include <windows.h>

// Define the JNIEXPORT and JNICALL macros if they're not already defined
#ifndef JNIEXPORT
#define JNIEXPORT __declspec(dllexport)
#endif

#ifndef JNICALL
#define JNICALL __stdcall
#endif

// Define the Java_ThreadNaming_setThreadName function
JNIEXPORT void JNICALL Java_ThreadNaming_setThreadName(JNIEnv *env, jobject obj, jstring jname) {
    const char *name = (*env)->GetStringUTFChars(env, jname, NULL);

    // Set the thread name using the Windows API
    HRESULT hr;
    hr = SetThreadDescription(GetCurrentThread(), name);

    (*env)->ReleaseStringUTFChars(env, jname, name);
}