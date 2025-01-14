#include <tchar.h>
#include <stdio.h>

static TCHAR frmdata[] = "-----------------------------7d82751e2bc0858\n"
                         "Content-Disposition: form-data; name=\"uploadedfile\"; filename=\"file.txt\"\n"
                         "Content-Type: text/plain\n\n"
                         "file contents  here\n"
                         "-----------------------------7d82751e2bc0858--";

static TCHAR hdrs[] = "Content-Type: multipart/form-data; boundary=---------------------------7d82751e2bc0858";

int _tmain(int argc, TCHAR* argv[])
{
    _tprintf(_T("%s\n"), frmdata);
    _tprintf(_T("%s\n"), hdrs);
    return 0;
}