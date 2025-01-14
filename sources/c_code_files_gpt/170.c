#include "FilePermissionChecker.h"
#include <stdio.h>

JNIEXPORT jboolean JNICALL Java_FilePermissionChecker_checkFileAccess
  (JNIEnv *env, jobject obj, jstring filePath, jstring mode) {
  // Convert jstring to char*
  const char *cFilePath = (*env)->GetStringUTFChars(env, filePath, NULL);
  const char *cMode = (*env)->GetStringUTFChars(env, mode, NULL);

  // Check file access (e.g., using access() function)
  int result = access(cFilePath, cMode[0] == 'r' ? R_OK : W_OK);

  // Release the jstring resources
  (*env)->ReleaseStringUTFChars(env, filePath, cFilePath);
  (*env)->ReleaseStringUTFChars(env, mode, cMode);

  // Return the result
  return result == 0 ? JNI_TRUE : JNI_FALSE;
}