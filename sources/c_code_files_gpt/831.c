#include <ntifs.h>
#include <wdf.h>

// Function to handle create and close requests
NTSTATUS
MyFilterCreateClose(
    PDEVICE_OBJECT DeviceObject,
    PIRP Irp
)
{
    PIO_STACK_LOCATION irpSp = IoGetCurrentIrpStackLocation(Irp);

    if (irpSp->MajorFunction == IRP_MJ_CREATE)
    {
        PEPROCESS process = IoGetRequestorProcess(Irp);
        CHAR imageName[256] = { 0 };

        if (process)
        {
            RtlCopyMemory(imageName, PsGetProcessImageFileName(process), sizeof(imageName));
            DbgPrint("File opened by process: %s\n", imageName);
        }
    }

    Irp->IoStatus.Status = STATUS_SUCCESS;
    IoCompleteRequest(Irp, IO_NO_INCREMENT);
    return STATUS_SUCCESS;
}

// Driver unload function
VOID
DriverUnload(
    _In_ PDRIVER_OBJECT DriverObject
)
{
    UNREFERENCED_PARAMETER(DriverObject);
    DbgPrint("Driver Unloading\n");
}

// Driver entry point
NTSTATUS
DriverEntry(
    _In_ PDRIVER_OBJECT DriverObject,
    _In_ PUNICODE_STRING RegistryPath
)
{
    UNREFERENCED_PARAMETER(RegistryPath);

    DriverObject->MajorFunction[IRP_MJ_CREATE] = MyFilterCreateClose;
    DriverObject->MajorFunction[IRP_MJ_CLOSE] = MyFilterCreateClose;
    DriverObject->DriverUnload = DriverUnload;

    DbgPrint("Driver Loaded\n");
    return STATUS_SUCCESS;
}