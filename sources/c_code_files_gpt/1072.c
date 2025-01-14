#include <zmq.h>
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

void *message_sender(void *context) {
    void *socket = zmq_socket(context, ZMQ_PUSH);
    zmq_connect(socket, "tcp://localhost:5555");

    for (int i = 0; i < 10; ++i) {
        char message[20];
        snprintf(message, sizeof(message), "Message %d", i);
        zmq_send(socket, message, strlen(message), 0);
        printf("Sent: %s\n", message);
        sleep(1);  // Simulating some work
    }

    zmq_close(socket);
    return NULL;
}

int main(void) {
    void *context = zmq_ctx_new();

    pthread_t sender_thread;
    pthread_create(&sender_thread, NULL, message_sender, context);

    // Wait for the sender thread to complete
    pthread_join(sender_thread, NULL);

    zmq_ctx_destroy(context);
    return 0;
}