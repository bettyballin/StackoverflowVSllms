#include <stdio.h> // For printf()
#include <time.h> // time(), difftime()

#define BUFFER_MAX 125000
#define OUTPUT_RATE 900/8

typedef struct leaky_bucket {
    double max;    /* maximum items in the bucket, a double for ease */
    double level;    /* number of things currently buffered         */
    double leakRate;
    time_t lastUpdateTime;  /* when was level updated?                        */
} leaky_bucket;

void lbstInit(leaky_bucket *l, double maxOutputQty, time_t interval) {
    /* Set the output parameters for leaking bucket. */
    l->lastUpdateTime = (time_t)0L;
    l->max = maxOutputQty;
    l->level = 0.0f;
    /* Calculate "leak rate" (in units per time-interval).   */
    l->leakRate = (double)OUTPUT_RATE / interval;
}

int addMsgToBucket(leaky_bucket *lb, double msgSize) {
    time_t now;  /* current time                             */
    size_t bytesLeft; /* msg space left in leaky bucket          */
    /* Get the elapsed time (in second).  The following is a standard trick to   */
    /* get rid of a possible negative value from -1 times.h wrapping, which      */
    /* does not matter if we're working with "real" and recent times             */
    now = (time_t) (((long) time(NULL)) > 0 ? ((long) time(NULL)):1);
    /* Adjust level for any untransmitted units, at the current output speed      */
    lb->level -= lb->leakRate * difftime(now, lb->lastUpdateTime);

    if (lb->level < 0.0f) {
        /* If we have excess space in bucket than limit its size to 0                */
        /* and reset last send time                             */
        lb->level = 0;
        lb->lastUpdateTime = now;
    }

    bytesLeft = (size_t)(lb->max - lb->level);
    /* Return the # of units that will fit into the bucket                      */
    if(bytesLeft < msgSize) {
        return -1 ; // Not enough space in leaky bucket for message. Dropping message
    } else{    /* Enough room left                */
        lb->level += msgSize;// Add message to the bucket
        bytesLeft -= (size_t)msgSize;/* Adjust remaining buffer size             */
        return 0 ; // Message successfully added to leakybucket
    }
}

int main() {
    leaky_bucket lb;
    lbstInit(&lb, BUFFER_MAX, 1); // Initialize the leaky bucket
    addMsgToBucket(&lb, 100); // Add a message to the bucket
    return 0;
}