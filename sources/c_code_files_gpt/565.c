#include <curl/curl.h>

int main() {
    CURL *curl;
    CURLcode res;

    // Initialize libcurl
    curl_global_init(CURL_GLOBAL_DEFAULT);

    // Create a libcurl handle
    curl = curl_easy_init();
    if(curl) {
        // Set up the SFTP session
        curl_easy_setopt(curl, CURLOPT_URL, "sftp://example.com");

        // Perform the SFTP operation
        res = curl_easy_perform(curl);

        // Check for errors
        if(res != CURLE_OK) {
            printf("cURL error: %s\n", curl_easy_strerror(res));
        }

        // Clean up
        curl_easy_cleanup(curl);
    }

    // Clean up libcurl
    curl_global_cleanup();

    return 0;
}