#include <d3d9.h>\n#include <iostream>\n\nint main() {\n    IDirect3D9* pDirect3D = Direct3DCreate9(D3D_SDK_VERSION);\n    if (pDirect3D == NULL) {\n        std::cerr << "Failed to create Direct3D object." << std::endl;\n        return -1;\n    }\n\n    D3DCAPS9 caps;\n    HRESULT hr = pDirect3D->GetDeviceCaps(D3DADAPTER_DEFAULT, D3DDEVTYPE_HAL, &caps);\n    if (FAILED(hr)) {\n        std::cerr << "Failed to get device capabilities." << std::endl;\n        pDirect3D->Release();\n        return -1;\n    }\n\n    // The device description can give you information about the GPU\n    std::cout << "Graphics Card: " << caps.DeviceDescription << std::endl;\n\n    pDirect3D->Release();\n    return 0;\n}