#include <curl/curl.h>

int main() {
    CURL *curl;
    CURLcode res;

    curl_global_init(CURL_GLOBAL_DEFAULT);
    curl = curl_easy_init();
    if(curl) {
        curl_easy_setopt(curl, CURLOPT_PROTOCOLS, CURLPROTO_FTP); // Use ftp protocol instead of http
        curl_easy_setopt(curl, CURLOPT_USERNAME, "YourUsername");
        curl_easy_setopt(curl, CURLOPT_PASSWORD, "YourPassword");

        /* Perform the request, res will get the return code */ 
        res = curl_easy_perform(curl);
        /* Check for errors */ 
        if(res != CURLE_OK)
            fprintf(stderr, "curl_easy_perform() failed: %s\n",
                    curl_easy_strerror(res));

        /* always cleanup */ 
        curl_easy_cleanup(curl);
    }

    curl_global_cleanup();
    return 0;
}