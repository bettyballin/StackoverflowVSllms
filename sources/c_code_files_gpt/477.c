#include "hdf5.h"

int main() {
    // Open an existing file
    hid_t file_id = H5Fopen("example.h5", H5F_ACC_RDWR, H5P_DEFAULT);

    // Check if the file was opened successfully
    if (file_id < 0) {
        printf("Error opening file\n");
        return 1;
    }

    // Delete the dataset
    herr_t status = H5Ldelete(file_id, "/dataset_name", H5P_DEFAULT);

    // Check if the dataset was deleted successfully
    if (status < 0) {
        printf("Error deleting dataset\n");
        H5Fclose(file_id);
        return 1;
    }

    // Close the file
    status = H5Fclose(file_id);

    // Check if the file was closed successfully
    if (status < 0) {
        printf("Error closing file\n");
        return 1;
    }

    return 0;
}