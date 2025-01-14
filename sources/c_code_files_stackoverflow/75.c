#define TIER_NORMAL 1
#define TIER_LITE 2 // Assuming TIER_LITE is meant to be defined with a value

int main() {
#ifdef TIER_NORMAL
    // do tier normal stuff
    printf("Doing tier normal stuff\n");
#endif

    return 0;
}