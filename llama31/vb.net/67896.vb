' Define an explicit interface\n[ComVisible(True)]\n[InterfaceType(ComInterfaceType.InterfaceIsDual)]\nPublic Interface IAClass\n    ' Methods and properties...\nEnd Interface\n\n' Implement the interface\n[ComVisible(True)]\n[ClassInterface(ClassInterfaceType.None)]\nPublic Class AClass\n    Implements IAClass\n    ' Implementation...\nEnd Class