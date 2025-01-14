#include <stdio.h>
#include <pthread.h>

pthread_mutex_t lock_it = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t write_it = PTHREAD_COND_INITIALIZER;

void* recv_acks(void *v) {
   for(;;) {
      pthread_mutex_lock(&lock_it);
      // Add a condition here to avoid infinite loop and yielding at every point. e.g., check if queue has acks, etc. before sending signal.
      printf("r1\n");
      pthread_cond_signal(&write_it);
      printf("r2\n");
      pthread_mutex_unlock(&lock_it);
   }
   return 0;
}

int main() {
    pthread_t thread;
    pthread_create(&thread, NULL, recv_acks, NULL);
    pthread_join(thread, NULL);
    return 0;
}