#include <jni.h>
#include "CryptoUtil.h"

// Example function to convert a jstring to a char*
const char* jstring2str(JNIEnv* env, jstring jstr) {
    char* rtn = NULL;
    jclass clsstring = (*env)->FindClass(env, "java/lang/String");
    jstring strencode = (*env)->NewStringUTF(env, "UTF-8");
    jmethodID mid = (*env)->GetMethodID(env, clsstring, "getBytes", "(Ljava/lang/String;)[B");
    jbyteArray barr = (jbyteArray)(*env)->CallObjectMethod(env, jstr, mid, strencode);
    jsize alen = (*env)->GetArrayLength(env, barr);
    jbyte* ba = (*env)->GetByteArrayElements(env, barr, JNI_FALSE);
    if (alen > 0) {
        rtn = (char*)malloc(alen + 1);
        memcpy(rtn, ba, alen);
        rtn[alen] = 0;
    }
    (*env)->ReleaseByteArrayElements(env, barr, ba, 0);
    return rtn;
}

JNIEXPORT jstring JNICALL Java_CryptoUtil_encrypt(JNIEnv *env, jobject obj, jstring data) {
    const char* str = jstring2str(env, data);
    if (str == NULL) {
        return NULL; // Handle error
    }
    // Example encryption logic: reverse the string
    int len = strlen(str);
    char* encrypted = malloc(len + 1);
    for (int i = 0; i < len; i++) {
        encrypted[i] = str[len - i - 1];
    }
    encrypted[len] = '\0';
    free((void*)str); // Don't forget to free the string
    
    return (*env)->NewStringUTF(env, encrypted);
}

JNIEXPORT jstring JNICALL Java_CryptoUtil_decrypt(JNIEnv *env, jobject obj, jstring data) {
    const char* str = jstring2str(env, data);
    if (str == NULL) {
        return NULL; // Handle error
    }
    // Example decryption logic: reverse the string back
    int len = strlen(str);
    char* decrypted = malloc(len + 1);
    for (int i = 0; i < len; i++) {
        decrypted[i] = str[len - i - 1];
    }
    decrypted[len] = '\0';
    free((void*)str); // Don't forget to free the string
    
    return (*env)->NewStringUTF(env, decrypted);
}