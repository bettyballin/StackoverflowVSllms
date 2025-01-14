#include <windows.h>

LRESULT CALLBACK my_callback(HWND hwnd, UINT ui, WPARAM wp, LPARAM lp) {
    Window * self = (Window*)GetWindowLongPtr(hwnd, 0);
    return self->update(hwnd, ui, wp, lp); // handle it.
}