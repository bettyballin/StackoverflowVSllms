#include <jni.h>

int main() {
    // Assuming 'env' is a valid JNIEnv* and 'obj' is the jobject reference
    JNIEnv* env;
    jobject obj;

    // Initialize env and obj here...

    if (obj != NULL) {
        jobject globalRef = (*env)->NewGlobalRef(env, obj);
        if (globalRef == NULL) {
            // Handle error: NewGlobalRef failed
        }
    } else {
        // Handle error: obj is NULL
    }

    return 0;
}