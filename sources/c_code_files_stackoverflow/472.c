#include <windows.h>

#define INDEXTOSTATEIMAGEMASK(i) ((i) << 12)

#define TreeView_SetItemState(hwndTV, hti, data, _mask) \
{ TVITEM _ms_TVi;\
  _ms_TVi.mask = TVIF_STATE; \
  _ms_TVi.hItem = (hti); \
  _ms_TVi.stateMask = (_mask);\
  _ms_TVi.state = (data);\
  SendMessage((hwndTV), TVM_SETITEM, 0, (LPARAM)(TV_ITEM *)&_ms_TVi);\
}

#define TreeView_SetCheckState(hwndTV, hti, fCheck) \
  TreeView_SetItemState(hwndTV, hti, INDEXTOSTATEIMAGEMASK((fCheck)?2:1), TVIS_STATEIMAGEMASK)

int main() {
  // Create a window with a tree view control
  HWND hWnd = CreateWindowEx(0, WC_TREEVIEW, "Tree View", WS_VISIBLE | WS_CHILD, 0, 0, 200, 200, NULL, NULL, NULL, NULL);

  // Get a handle to an item in the tree view
  HTREEITEM hti = TreeView_InsertItem(hWnd, TVI_ROOT, "Item 1");

  // Set the check state of the item
  TreeView_SetCheckState(hWnd, hti, TRUE);

  // Run the message loop
  MSG msg;
  while (GetMessage(&msg, NULL, 0, 0)) {
    TranslateMessage(&msg);
    DispatchMessage(&msg);
  }

  return 0;
}