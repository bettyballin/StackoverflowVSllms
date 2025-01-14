#include <windows.h>

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow)
{
    HANDLE ghJob = CreateJobObject(NULL, NULL); // GLOBAL
    if (ghJob == NULL)
    {
        MessageBox(NULL, "Could not create job object", "TEST", MB_OK);
    }
    else
    {
        JOBOBJECT_EXTENDED_LIMIT_INFORMATION jeli = {0};

        // Configure all child processes associated with the job to terminate when the
        jeli.BasicLimitInformation.LimitFlags = JOB_OBJECT_LIMIT_KILL_ON_JOB_CLOSE;
        if (0 == SetInformationJobObject(ghJob, JobObjectExtendedLimitInformation, &jeli, sizeof(jeli)))
        {
            MessageBox(NULL, "Could not SetInformationJobObject", "TEST", MB_OK);
        }
    }
    return 0;
}