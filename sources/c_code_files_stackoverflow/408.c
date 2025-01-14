#include <stdio.h>

typedef struct {
    long start_int_idx;
    int current_int_idx;
    // ... other fields ...
} serial_info_t;

/*
** These could be omitted - unless you get still more radical and create
** the format strings at run-time, so you can adapt the %-24s to the
** longest tag you actually have.  Plus, with the strings all here, when
** you change the length from 24 to 30, you are less likely to overlook one!
*/
static const char fmt_int[]  = "%-24s [%d]\n";
static const char fmt_long[] = "%-24s [%ld]\n";
static const char fmt_str[]  = "%-24s [%s]\n";   /* Plausible extra ... */

static inline void print_long(FILE *fp, const char *tag, long value)
{
    fprintf(fp, fmt_long, tag, value);
}

static inline void print_int(FILE *fp, const char *tag, int value)
{
    fprintf(fp, fmt_int, tag, value);
}

static inline void print_str(FILE *fp, const char *tag, const char *value)
{
    fprintf(fp, fmt_str, tag, value);
}

static void dump_data(FILE *fp, const serial_info_t *info)
{
    print_long(fp, "Starting serial number", info->start_int_idx);
    print_int(fp, "Current Serial number",  info->current_int_idx);
    /* ... and similar ... */
}

int main() {
    serial_info_t info = {1, 2};
    dump_data(stdout, &info);
    return 0;
}