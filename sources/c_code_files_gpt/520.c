#include <windows.h>
#include <ntifs.h>

NTSTATUS NtCreateFile(
      PHANDLE            FileHandle,
      ACCESS_MASK        DesiredAccess,
      POBJECT_ATTRIBUTES ObjectAttributes,
      PIO_STATUS_BLOCK   IoStatusBlock,
      PLARGE_INTEGER     AllocationSize,
      ULONG              FileAttributes,
      ULONG              ShareAccess,
      ULONG              CreateDisposition,
      ULONG              CreateOptions,
      PVOID              EaBuffer,
      ULONG              EaLength
    );

int main() {
    // You would need to call the NtCreateFile function from here
    return 0;
}