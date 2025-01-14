#include <jvmti.h>
#include <jni.h>

JNIEXPORT jint JNICALL Agent_OnAttach(JavaVM *vm, char *options, void *reserved) {
    jvmtiEnv *jvmti;
    (*vm)->GetEnv(vm, (void **)&jvmti, JVMTI_VERSION_1_0);

    jvmtiError error = jvmti->SetEventNotificationMode(jvmti, JVMTI_ENABLE, JVMTI_EVENT_BREAKPOINT, NULL);
    if (error != JVMTI_ERROR_NONE) {
        return JNI_ERR;
    }

    return JNI_OK;
}

int main() {
    // This is just a dummy main function to make the code compile.
    // The Agent_OnAttach function will be called by the JVM when the agent is attached.
    return 0;
}