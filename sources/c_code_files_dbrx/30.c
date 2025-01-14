#include <curl/curl.h>

int main() {
    CURL *curl;

    curl_global_init(CURL_GLOBAL_DEFAULT);
    curl = curl_easy_init();

    if(curl) {
        curl_easy_setopt(curl, CURLOPT_URL, "ftp://example.com/path/to/uploaded/file");
        curl_easy_perform(curl);
        curl_easy_cleanup(curl);
    }

    curl_global_cleanup();

    return 0;
}