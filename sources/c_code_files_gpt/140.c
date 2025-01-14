#include <jni.h>
#include <stdio.h>
#include <sys/socket.h>
#include <stdlib.h>

// Since we're testing outside of JNI, we don't include "Socket.h"
// #include "Socket.h"

// Define a mock structure to represent the Java environment and object for testing
typedef struct {
    void* reserved0;
    void* reserved1;
    void* reserved2;
    void* reserved3;
} JNIEnv;

typedef struct {
    int something; // Just a placeholder
} jobject;

// Function prototype for our JNI function
JNIEXPORT void JNICALL
Java_Socket_socketCreate(JNIEnv *env, jobject obj, jboolean stream);

// Implementation of the JNI function
JNIEXPORT void JNICALL
Java_Socket_socketCreate(JNIEnv *env, jobject obj, jboolean stream) {
    int sock;
    if (stream) {
        sock = socket(AF_INET, SOCK_STREAM, 0);
    } else {
        sock = socket(AF_INET, SOCK_DGRAM, 0);
    }
    if (sock < 0) {
        perror("socket creation failed");
        exit(EXIT_FAILURE);
    }
    // For demonstration, print the socket descriptor
    printf("Socket created successfully: %d\n", sock);
    close(sock); // Close the socket to avoid leaks
}

int main() {
    // Mocking the JNI environment and object
    JNIEnv env;
    jobject obj;
    
    // Call the JNI function with stream = JNI_TRUE
    Java_Socket_socketCreate(&env, &obj, JNI_TRUE);
    
    // Call the JNI function with stream = JNI_FALSE
    Java_Socket_socketCreate(&env, &obj, JNI_FALSE);
    
    return 0;
}