#include <iostream>\n#include <comdef.h>\n#include <msxml6.h>\n\n#pragma comment(lib, "msxml6.lib")\n\nvoid traverseXML(IXMLDOMDocument* pXMLDom) {\n    IXMLDOMNode* pNode = nullptr;\n    IXMLDOMNode* pSubNode = nullptr;\n    HRESULT hr;\n    \n    // Load the XML from a string or file\n    VARIANT_BOOL success;\n    hr = pXMLDom->load(_variant_t("path_to_your_xml_file.xml"), &success);\n    if (FAILED(hr) || success == VARIANT_FALSE) {\n        std::cerr << "Failed to load XML" << std::endl;\n        return;\n    }\n\n    // Select the HIVE node with the specific Name attribute\n    hr = pXMLDom->selectSingleNode(L"//HIVE[@Name='HKEY_CUREENT_USER']", &pNode);\n    if (SUCCEEDED(hr) && pNode) {\n        // Select the KEY node within the found HIVE node\n        hr = pNode->selectSingleNode(L"KEYS/Key[@Name='Network']", &pSubNode);\n        if (SUCCEEDED(hr) && pSubNode) {\n            // Successfully found the node\n            std::wcout << L"Path 'HKEY_CUREENT_USER\\Network' found." << std::endl;\n            pSubNode->Release();\n        } else {\n            std::cerr << "Network key not found" << std::endl;\n        }\n        pNode->Release();\n    } else {\n        std::cerr << "HIVE with Name 'HKEY_CUREENT_USER' not found" << std::endl;\n    }\n}\n\nint main() {\n    CoInitialize(NULL);\n\n    IXMLDOMDocument* pXMLDom = nullptr;\n    HRESULT hr = CoCreateInstance(__uuidof(DOMDocument60), NULL, CLSCTX_INPROC_SERVER, IID_PPV_ARGS(&pXMLDom));\n    if (SUCCEEDED(hr) && pXMLDom) {\n        pXMLDom->put_async(VARIANT_FALSE);\n        pXMLDom->put_validateOnParse(VARIANT_FALSE);\n        pXMLDom->put_resolveExternals(VARIANT_FALSE);\n\n        traverseXML(pXMLDom);\n\n        pXMLDom->Release();\n    } else {\n        std::cerr << "Failed to create XML DOM instance" << std::endl;\n    }\n\n    CoUninitialize();\n    return 0;\n}