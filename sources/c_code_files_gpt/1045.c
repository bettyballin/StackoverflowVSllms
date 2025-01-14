#include <jni.h>
#include <stdio.h>

JNIEXPORT void JNICALL Java_NativeLibrary_printMessage(JNIEnv *env, jobject obj) {
    printf("Hello from C!\n");
}