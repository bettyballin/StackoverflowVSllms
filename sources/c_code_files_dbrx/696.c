#include <stdio.h>
#include <curl/curl.h>
#include <string.h>

// Custom function to handle incoming data (optional, refer libcurl's documentations)
size_t write_data(void *ptr, size_t size, size_t nmemb, FILE *stream) {
    size_t written = fwrite(ptr, size, nmemb, stream);
    return written;
}

int main() {
    const char *data = "sample data string"; // Replace with your payload
    CURL *curl;
    CURLcode res;

    // Initialize curl library
    curl_global_init(CURL_GLOBAL_DEFAULT);
    curl = curl_easy_init();
    if (!curl) return -1; // Handle error condition

    struct curl_slist *headers=NULL;
    headers = curl_slist_append(headers, "Content-Type: text/plain"); // Set appropriate data type as per your web service contract

    // Set API endpoint (Replace with actual URL)
    curl_easy_setopt(curl, CURLOPT_URL, "http://mywebservice.com/api/upload");
    curl_easy_setopt(curl, CURLOPT_HTTPHEADER, headers); // Add any additional header requirements as per your web service contract
    // Prepare content
    curl_easy_setopt(curl, CURLOPT_POSTFIELDS, data);
    // Send POST request with provided payload (Make sure Content-Length header is set for larger amounts of data)
    // No need to set CURLOPT_COPYPOSTFIELDS, libcurl will automatically set the Content-Length header

    // Open a file to save the response
    FILE *file_handle = fopen("response.txt", "w");
    if (!file_handle) {
        curl_easy_cleanup(curl);
        curl_global_cleanup();
        return -1; // Handle error condition
    }

    // Perform HTTP POST operation and save the response to a file ('response.txt')
    curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, write_data); // Custom function to handle incoming data (optional, refer libcurl's documentations)
    curl_easy_setopt(curl, CURLOPT_WRITEDATA, file_handle); // File pointer where response is written (optional)
    res = curl_easy_perform(curl);  // Invoke the API and get result back

    // Clean up
    curl_easy_cleanup(curl);
    curl_global_cleanup();
    fclose(file_handle);

    return 0;
}