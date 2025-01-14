#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define LOG_FILE "transaction.log"
#define DATA_FILE "data.txt"

void write_log(const char *data) {
    FILE *log = fopen(LOG_FILE, "w");
    if (log == NULL) {
        perror("Failed to open log file");
        exit(EXIT_FAILURE);
    }
    fprintf(log, "%s", data);
    fclose(log);
}

void commit_transaction(const char *data) {
    FILE *file = fopen(DATA_FILE, "w");
    if (file == NULL) {
        perror("Failed to open data file");
        exit(EXIT_FAILURE);
    }
    fprintf(file, "%s", data);
    fclose(file);
    remove(LOG_FILE); // Remove log after successful commit
}

void recover_from_log() {
    FILE *log = fopen(LOG_FILE, "r");
    if (log != NULL) {
        char data[256];
        fgets(data, sizeof(data), log);
        commit_transaction(data); // Apply log data to the main file
        fclose(log);
    }
}

int main() {
    recover_from_log(); // Ensure recovery at startup

    // Example transaction
    const char *new_data = "Example data to write\n";
    write_log(new_data); // Log the data
    commit_transaction(new_data); // Commit the data

    return 0;
}