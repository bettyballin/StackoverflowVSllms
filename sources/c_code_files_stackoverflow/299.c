#include <curl/curl.h>
#include <assert.h>

int main() {
    CURL *Handle = curl_easy_init();

    // Read cookies from a previous session, as stored in MyCookieFileName.
    curl_easy_setopt( Handle, CURLOPT_COOKIEFILE, "MyCookieFileName" );
    // Save cookies from *this* session in MyCookieFileName
    curl_easy_setopt( Handle, CURLOPT_COOKIEJAR, "MyCookieFileName" );

    curl_easy_setopt( Handle, CURLOPT_URL, "MyLoginPageUrl" );
    assert( curl_easy_perform( Handle ) == CURLE_OK );

    curl_easy_setopt( Handle, CURLOPT_URL, "MyActionPageUrl" );
    assert( curl_easy_perform( Handle ) == CURLE_OK );

    // The cookies are actually saved here.
    curl_easy_cleanup( Handle );

    return 0;
}