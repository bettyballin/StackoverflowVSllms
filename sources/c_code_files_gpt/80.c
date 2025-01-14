#include <windows.h>

int main() {
    PROCESS_MITIGATION_DYNAMIC_CODE_POLICY policy;
    policy.ProhibitDynamicCode = 1;
    SetProcessMitigationPolicy(ProcessDynamicCodePolicy, &policy, sizeof(policy));
    return 0;
}