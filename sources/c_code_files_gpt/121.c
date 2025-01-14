#include <jni.h>
#include <jvmti.h>
#include <stdio.h>

static void JNICALL ExceptionCallback(jvmtiEnv *jvmti_env, JNIEnv* jni_env, jthread thread, jmethodID method, jlocation location, jobject exception, jmethodID catch_method, jlocation catch_location) {
    // Capture the stack trace
    jvmtiFrameInfo frames[10];
    jint count;
    (*jvmti_env)->GetStackTrace(jvmti_env, thread, 0, 10, frames, &count);

    // Print the stack trace
    for (int i = 0; i < count; i++) {
        char *method_name;
        (*jvmti_env)->GetMethodName(jvmti_env, frames[i].method, &method_name, NULL, NULL);
        printf("Method: %s\n", method_name);
        (*jvmti_env)->Deallocate(jvmti_env, (unsigned char*)method_name);
    }

    // Capture local variables (this part is more complex and may need additional handling)
    // ...

    // Save data to a file (JSON, XML, etc.)
    // ...
}

JNIEXPORT jint JNICALL Agent_OnLoad(JavaVM *vm, char *options, void *reserved) {
    jvmtiEnv *jvmti;
    jint result = (*vm)->GetEnv(vm, (void **)&jvmti, JVMTI_VERSION_1_0);
    if (result != JNI_OK) {
        return result;
    }

    jvmtiEventCallbacks callbacks;
    callbacks.Exception = ExceptionCallback;
    (*jvmti)->SetEventCallbacks(jvmti, &callbacks, sizeof(callbacks));
    (*jvmti)->SetEventNotificationMode(jvmti, JVMTI_ENABLE, JVMTI_EVENT_EXCEPTION, NULL);

    return JNI_OK;
}