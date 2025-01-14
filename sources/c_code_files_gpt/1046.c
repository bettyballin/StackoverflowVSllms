// C implementation of the native method
#include <jni.h>
#include <tesseract/capi.h>
#include <leptonica/allheaders.h>
#include "TesseractJNI.h"

JNIEXPORT jstring JNICALL Java_TesseractJNI_performOCR(JNIEnv *env, jobject obj, jbyteArray imageData) {
    // Convert jbyteArray to native byte array
    jbyte *data = (*env)->GetByteArrayElements(env, imageData, NULL);
    jsize length = (*env)->GetArrayLength(env, imageData);

    // Load image from byte array
    PIX *image = pixReadMem((const l_uint8 *)data, length);

    // Perform OCR
    TessBaseAPI *api = TessBaseAPICreate();
    TessBaseAPIInit3(api, NULL, "eng");
    TessBaseAPISetImage2(api, image);
    char *text = TessBaseAPIGetUTF8Text(api);

    // Release resources
    jstring result = (*env)->NewStringUTF(env, text);
    TessBaseAPIDelete(api);
    pixDestroy(&image);
    (*env)->ReleaseByteArrayElements(env, imageData, data, JNI_ABORT);
    return result;
}