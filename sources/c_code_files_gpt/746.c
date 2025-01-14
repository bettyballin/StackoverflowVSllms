#include <jni.h>
#include <stdio.h>
#include "HelloWorld.h"

// Implementation of the native method
JNIEXPORT void JNICALL Java_HelloWorld_printHelloWorld(JNIEnv *env, jobject obj) {
    printf("Hello, World!\n");
}

int main() {
    // This is a JNI function, it's not meant to be called from C, but from Java.
    // However, we can simulate the call for demonstration purposes.
    Java_HelloWorld_printHelloWorld(NULL, NULL);
    return 0;
}