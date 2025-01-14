Imports System.Runtime.InteropServices\n\n' Assuming MyItems is a class that wraps the COM interface\nPublic Class MyItemsWrapper\n    <ComImport(), Guid("YourCOMObjectGuid"), InterfaceType(ComInterfaceType.InterfaceIsDual)>\n    Private Interface IMyItems\n        Sub AddItems(ByVal numItems As Integer, _\n                     <MarshalAs(UnmanagedType.LPArray, SizeParamIndex:=0)> ByVal itemIDs As String(), _\n                     <MarshalAs(UnmanagedType.LPArray, ArraySubType:=UnmanagedType.I4, SizeParamIndex:=0)> ByVal itemClientHandles As Integer(), _\n                     <MarshalAs(UnmanagedType.ByValArray, ArraySubType:=UnmanagedType.I4, SizeConst:=2)> ByRef myItemServerHandles() As Integer, _\n                     <MarshalAs(UnmanagedType.ByValArray, ArraySubType:=UnmanagedType.I4, SizeConst:=2)> ByRef errors() As Integer)\n    End Interface\n\n    Private mComObject As IMyItems\n\n    Public Sub New()\n        ' Initialize the COM object\n        mComObject = DirectCast(Activator.CreateInstance(Type.GetTypeFromProgID("YourCOMObjectName")), IMyItems)\n    End Sub\n\n    Public Sub AddItems(ByVal numItems As Integer, _\n                         ByVal itemIDs As String(), _\n                         ByVal itemClientHandles As Integer(), _\n                         ByRef myItemServerHandles() As Integer, _\n                         ByRef errors() As Integer)\n\n        mComObject.AddItems(numItems, itemIDs, itemClientHandles, myItemServerHandles, errors)\n    End Sub\nEnd Class\n\n' Usage\nDim myItems As New MyItemsWrapper()\nDim itemIDs(1) As String ' Adjusted to 0-based index\nDim itemClientHandles(1) As Integer ' Adjusted to 0-based index\nDim myItemServerHandles(1) As Integer ' Adjusted to 0-based index with initial size\nDim errors(1) As Integer ' Adjusted to 0-based index with initial size\n\nitemIDs(0) = "2,VW1000,word"\nitemIDs(1) = "2,VW1002,word"\n\nitemClientHandles(0) = 1\nitemClientHandles(1) = 2\n\nmyItems.AddItems(itemIDs.Length, itemIDs, itemClientHandles, myItemServerHandles, errors)