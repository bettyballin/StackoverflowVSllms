#include <stdio.h>

struct table_format_header {
  int number_of_fields; /* number of fields that will be defined in table */
                        /* sent before the field descriptions themselves  */
};

struct table_format {
   char column_name[8];   /* name of column ("sensor");  */
   char fmt_specifier[5]; /* format specifier for column */
   // ... (etc) - Add any other fields as necessary
};

int main() {
    // Example usage of the structures
    struct table_format_header header;
    header.number_of_fields = 2;

    struct table_format format;
    strcpy(format.column_name, "sensor");
    strcpy(format.fmt_specifier, "%d");

    printf("Header: Number of fields = %d\n", header.number_of_fields);
    printf("Format: Column name = %s, Format specifier = %s\n", format.column_name, format.fmt_specifier);

    return 0;
}