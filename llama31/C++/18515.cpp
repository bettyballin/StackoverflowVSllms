_variant_t var = pRs->Fields->GetItem(i)->GetValue();\n\nif (V_VT(&var) == VT_BSTR)\n{\n    BSTR bstr = V_BSTR(&var);\n    char* p = (char*) bstr;\n    // use p\n    SysFreeString(bstr); // don't forget to free the BSTR\n}