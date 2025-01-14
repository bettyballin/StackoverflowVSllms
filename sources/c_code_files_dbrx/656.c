#include <stdio.h>
#include <stdlib.h>

/* This is the actual function pointer typedef */
typedef void (*event_cb_t)(const struct event *evt, void *user_data);

struct event {
    int type; /* just some data to demonstrate its usage in callback function*/
};

struct event_cb {
     event_cb_t cb;
     void *data;
};

int event_cb_register(event_cb_t _cb, void *user_data);

/* Define custom event structure */
typedef struct myCustEvent {
    int type; /* any data you wish to pass to your callback function*/
} myCustEvent;

static void my_event_cb(const struct event *evt, void *data) {
     /* do some stuff with evt and user_defined data */
     printf("Inside my custom callback!\n");
     printf("Received Event Type: %d\nUser defined Struct value: %d\n", evt->type, ((myCustEvent*)data)->type);
}

int main(void) {
    /* Register your event handler */
    myCustEvent userData = {34};
    event_cb_register(my_event_cb, &userData);

     struct event myEvent;

     myEvent.type = 65687;

     /* Here you can dispatch the "events" for callbacks */
     printf("Before Dispatching Event\n");
     /* Note: You need to maintain the list of registered callback functions somewhere and iterate over them in your event_dispatcher function,
      assuming it's called dispatcher here.*/
    // dispatcher(&myEvent); /* Call for each registered callback */

     printf("After Dispatching Event\n");
     return 0;
}
/* Register event handler function, add it to your list of callback functions somewhere in memory. Below function just accepts the pointer and returns the address which you can store*/
int event_cb_register(event_cb_t _cb, void *user_data) {
    struct event_cb *callback = malloc(sizeof (struct event_cb));

    callback->cb = _cb; /*Store the function pointer inside your event handler structure. */
    callback->data = user_data; /* Store any custom data you want to be passed to this callback*/
    return 0; // Return a value to avoid warning
}