#include <jni.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <errno.h>
#include <pwd.h>
#include "FilePermissionChecker.h"

JNIEXPORT jboolean JNICALL Java_FilePermissionChecker_checkFileAccess(JNIEnv *env, jobject obj, jstring path, jstring username) {
    const char *filePath = (*env)->GetStringUTFChars(env, path, 0);
    const char *user = (*env)->GetStringUTFChars(env, username, 0);

    struct passwd *pwd = getpwnam(user);
    if (pwd == NULL) {
        (*env)->ReleaseStringUTFChars(env, path, filePath);
        (*env)->ReleaseStringUTFChars(env, username, user);
        return JNI_FALSE;
    }

    uid_t original_uid = geteuid();
    seteuid(pwd->pw_uid);

    int result = access(filePath, R_OK);

    seteuid(original_uid);

    (*env)->ReleaseStringUTFChars(env, path, filePath);
    (*env)->ReleaseStringUTFChars(env, username, user);

    return (result == 0) ? JNI_TRUE : JNI_FALSE;
}

int main() {
    // Create a mock JNIEnv and jobject
    JNIEnv env;
    jobject obj;

    // Create a mock jstring for the path and username
    jstring path = (*env)->NewStringUTF(env, "/path/to/file");
    jstring username = (*env)->NewStringUTF(env, "username");

    // Call the Java_FilePermissionChecker_checkFileAccess function
    jboolean result = Java_FilePermissionChecker_checkFileAccess(&env, obj, path, username);

    // Print the result
    printf("File access result: %d\n", result);

    return 0;
}