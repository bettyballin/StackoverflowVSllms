#include "hdf5.h"

int main() {
    // Open an existing file
    hid_t file_id = H5Fopen("example.h5", H5F_ACC_RDWR, H5P_DEFAULT);

    // Open an existing dataset
    hid_t dataset_id = H5Dopen(file_id, "/dataset_name", H5P_DEFAULT);

    // Define the new data to be written
    int new_data[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    // Write the new data to the dataset
    H5Dwrite(dataset_id, H5T_NATIVE_INT, H5S_ALL, H5S_ALL, H5P_DEFAULT, new_data);

    // Close the dataset and file
    H5Dclose(dataset_id);
    H5Fclose(file_id);

    return 0;
}