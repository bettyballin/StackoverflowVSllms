#include <pthread.h>
#include <libspe2.h>

// Define the SPE program structure
extern spe_program_handle_t my_spe_program;

void *spe_thread_function(void *arg) {
    spe_context_ptr_t ctx = (spe_context_ptr_t)arg;
    unsigned int entry = SPE_DEFAULT_ENTRY;
    
    if (spe_program_load(ctx, &my_spe_program) != 0) {
        // Error handling for program load failure
    }
    
    if (spe_context_run(ctx, &entry, 0, NULL, NULL, NULL) != 0) {
        // Error handling for context run failure
    }
    
    spe_context_destroy(ctx);
    return NULL;
}

int main() {
    pthread_t thread;
    spe_context_ptr_t ctx;

    ctx = spe_context_create(0, NULL);
    if (ctx == NULL) {
        // Error handling for context creation failure
    }
    
    pthread_create(&thread, NULL, spe_thread_function, (void *)ctx);
    pthread_join(thread, NULL);

    return 0;
}