#include <stdio.h>

// Defining the event structure
struct event {
    int type;
};

// Typedef for event callback function pointer
typedef void (*event_cb_t)(const struct event *evt, void *user_data);

// Struct to hold the callback and its data
struct event_cb {
    event_cb_t cb;
    void *data;
};

// Function to register the callback
int event_cb_register(event_cb_t cb, void *user_data) {
    if (cb == NULL) {
        return -1; // Error: Null callback
    }

    // For simplicity, just store the callback and data in static variables
    static struct event_cb registered_cb;
    registered_cb.cb = cb;
    registered_cb.data = user_data;

    // Simulate an event dispatch to demonstrate callback invocation
    struct event evt = { .type = 1 };
    registered_cb.cb(&evt, registered_cb.data);

    return 0; // Success
}

// Example callback function
static void my_event_cb(const struct event *evt, void *data) {
    printf("Event type: %d, User data: %s\n", evt->type, (char *)data);
}

int main(void) {
    char my_custom_data[] = "Custom Data";

    // Register the callback
    if (event_cb_register(my_event_cb, my_custom_data) != 0) {
        fprintf(stderr, "Failed to register callback\n");
        return 1;
    }

    return 0;
}