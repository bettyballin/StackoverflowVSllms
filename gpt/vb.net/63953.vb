Imports System.Runtime.InteropServices\n\n<ComVisible(True)>\n<Guid("12345678-1234-1234-1234-1234567890AB")>\n<InterfaceType(ComInterfaceType.InterfaceIsIDispatch)>\nPublic Interface IMyComInterface\n    <DispId(1)>\n    Sub MyComMethod()\nEnd Interface\n\n<ComVisible(True)>\n<Guid("87654321-4321-4321-4321-BA0987654321")>\n<ClassInterface(ClassInterfaceType.None)>\nPublic Class MyComClass\n    Implements IMyComInterface\n\n    Public Sub MyComMethod() Implements IMyComInterface.MyComMethod\n        ' Implementation of the method\n    End Sub\nEnd Class