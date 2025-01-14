#include <jni.h>
#include <stdio.h>
#include "YourJavaClass.h"

int main() {
    JavaVM *jvm;
    JNIEnv *env;
    JavaVMInitArgs vm_args;
    JavaVMOption options[1];

    options[0].optionString = "-Djava.class.path=/path/to/your/classes";
    vm_args.version = JNI_VERSION_1_6;
    vm_args.nOptions = 1;
    vm_args.options = options;
    vm_args.ignoreUnrecognized = JNI_FALSE;

    JNI_CreateJavaVM(&jvm, (void**)&env, &vm_args);

    jclass cls = (*env)->FindClass(env, "YourJavaClass");
    jmethodID mid = (*env)->GetMethodID(env, cls, "yourMethod", "()Ljava/lang/String;");
    jobject obj = (*env)->AllocObject(env, cls);
    jstring result = (jstring)(*env)->CallObjectMethod(env, obj, mid);

    const char *str = (*env)->GetStringUTFChars(env, result, 0);
    printf("%s\n", str);
    (*env)->ReleaseStringUTFChars(env, result, str);

    (*jvm)->DestroyJavaVM(jvm);
    return 0;
}