#include <afx.h>\n#include <regex>\n\nbool IsValidHostname(const CString& hostname) {\n    // Simple regex for IPv4 and basic hostnames\n    std::wregex ipv4Regex(L"\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b");\n    std::wregex hostnameRegex(L"^(?=.{1,255}$)[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+$");\n\n    return std::regex_match(hostname.GetString(), ipv4Regex) || std::regex_match(hostname.GetString(), hostnameRegex);\n}\n\nbool IsValidPortNumber(const CString& port) {\n    // Convert CString to int\n    unsigned long value = _ttoi(port);\n\n    // Check if the conversion was successful and the number is within valid range\n    return (value > 0 && value <= 65535);\n}\n\nvoid ValidateProxySettings(CString hostname, CString port) {\n    if (!IsValidHostname(hostname)) {\n        AfxMessageBox(_T("Invalid Hostname or IP address."));\n        return;\n    }\n\n    if (!IsValidPortNumber(port)) {\n        AfxMessageBox(_T("Invalid Port number. It must be between 1 and 65535."));\n        return;\n    }\n\n    // Proceed with using the hostname and port\n    AfxMessageBox(_T("Hostname and Port are valid."));\n}