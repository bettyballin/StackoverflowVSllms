#include <jni.h>
#include "NativeExample.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_NativeExample_printMessage(JNIEnv *env, jobject obj) {
    printf("Hello from native code!\n");
}