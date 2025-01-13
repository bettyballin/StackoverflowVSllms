#include <comdef.h>\n#include <sstream>\n#include <string>\n#include <iomanip>\n\nvoid LoadRecordsetIntoStream(_RecordsetPtr& pRs, std::ostringstream& ostrm)\n{\n    ADODB::FieldsPtr pFields = pRs->Fields;\n    ::SYSTEMTIME sysTime;\n    _variant_t var;\n\n    // Preallocate space based on an estimate\n    ostrm.str("");\n    ostrm.reserve(10000000); // reserve 10MB, adjust based on your data size\n\n    while (!pRs->EndOfFile) // loop through rows\n    {\n        for (long i = 0L; i < pFields->Count; i++)  // loop through columns\n        {\n            var = pFields->GetItem(i)->Value;\n\n            switch (V_VT(&var))\n            {\n            case VT_BSTR:\n                ostrm << (const char*)(_bstr_t)var;\n                break;\n\n            case VT_I4:\n            case VT_UI1:\n            case VT_I2:\n            case VT_BOOL:\n                ostrm << std::to_string((int)var);\n                break;\n\n            case VT_DATE:\n                ::VariantTimeToSystemTime(var, &sysTime);\n                ostrm << std::setfill('0') << std::setw(4) << sysTime.wYear << '-'\n                      << std::setw(2) << sysTime.wMonth << '-'\n                      << std::setw(2) << sysTime.wDay << ' '\n                      << std::setw(2) << sysTime.wHour << ':'\n                      << std::setw(2) << sysTime.wMinute << ':'\n                      << std::setw(2) << sysTime.wSecond;\n                break;\n\n            default:\n                // Handle other types if needed\n                break;\n            }\n        }\n        pRs->MoveNext();\n    }\n}