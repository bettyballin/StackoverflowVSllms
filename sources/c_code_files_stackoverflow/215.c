#include <windows.h>
#include <objbase.h>
#include <memory>

// Assuming Image class is defined elsewhere
class Image {
public:
    Image(IStream* stream);
};

std::shared_ptr<Image> CreateImage(BYTE *blob, size_t blobSize)
{
    HGLOBAL hMem = ::GlobalAlloc(GMEM_MOVEABLE, blobSize);
    BYTE *pImage = (BYTE*)::GlobalLock(hMem);

    for (size_t iBlob = 0; iBlob < blobSize; ++iBlob)
        pImage[iBlob] = blob[iBlob];

    ::GlobalUnlock(hMem);

    CComPtr<IStream> spStream;
    HRESULT hr = ::CreateStreamOnHGlobal(hMem, TRUE, &spStream);

    std::shared_ptr<Image> image = std::make_shared<Image>(spStream);
    return image;
}