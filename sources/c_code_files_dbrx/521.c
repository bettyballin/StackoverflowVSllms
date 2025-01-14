#include <curl/curl.h>

int main(void) {
    CURL *curl;
    CURLcode res;

    curl_global_init(CURL_GLOBAL_DEFAULT);
    curl = curl_easy_init();
    if(curl) {
        curl_easy_setopt(curl, CURLOPT_URL, "http://example.com");
        /* Perform the request, res will get the return code */ 
        res = curl_easy_perform(curl);
        /* Check for errors */ 
        if(res != CURLE_OK)
            fprintf(stderr, "cURL error: %s\n", curl_easy_strerror(res));
        /* always cleanup */ 
        curl_easy_cleanup(curl);
    }
    curl_global_cleanup();

    return 0;
}