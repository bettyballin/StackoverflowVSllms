#include <curl/curl.h>

int main() {
    CURL *handle;
    CURLcode res;

    handle = curl_easy_init();
    if(handle) {
        struct curl_slist *customHeader = NULL;
        char HeaderData[50] = "Accept-Charset: utf-8"; // Specify encoding as UTF-8.
        customHeader = curl_slist_append(customHeader, HeaderData); // Add header to list.

        curl_easy_setopt(handle, CURLOPT_ACCEPT_ENCODING, "gzip"); // Use gzip compression.
        curl_easy_setopt(handle, CURLOPT_HTTPHEADER, customHeader); // Create a custom HTTP header to specify your encoding preference.

        // You must set a URL here
        curl_easy_setopt(handle, CURLOPT_URL, "http://example.com");

        /* Perform the request, res will get the return code */ 
        res = curl_easy_perform(handle);
        /* Check for errors */ 
        if(res != CURLE_OK)
            fprintf(stderr, "cURL error: %s\n", curl_easy_strerror(res));

        /* always cleanup */ 
        curl_easy_cleanup(handle);
        curl_slist_free_all(customHeader);
    }
    return 0;
}