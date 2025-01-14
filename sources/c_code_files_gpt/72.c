#include <windows.h>

int main() {
    PROCESS_MITIGATION_BINARY_SIGNATURE_POLICY policy;
    policy.MicrosoftSignedOnly = 1;
    SetProcessMitigationPolicy(ProcessSignaturePolicy, &policy, sizeof(policy));
    return 0;
}