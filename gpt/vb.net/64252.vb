' Define the interfaces\nPublic Interface IDBFile\n    ' Interface members here\nEnd Interface\n\nPublic Interface IDBFileContent\n    ' Interface members here\nEnd Interface\n\nPublic Interface IDBFileThumb\n    ' Interface members here\nEnd Interface\n\n' Define a class that inherits from DBFileManager\nPublic Class MyDBFileManager\n    Inherits DBFileManager(Of MyDBFile, MyDBFileContent, MyDBFileThumb)\n    \n    ' Implementation of abstract class members here\nEnd Class\n\n' Concrete implementations of the interfaces\nPublic Class MyDBFile\n    Implements IDBFile\n    ' Implementation of IDBFile members\nEnd Class\n\nPublic Class MyDBFileContent\n    Implements IDBFileContent\n    ' Implementation of IDBFileContent members\nEnd Class\n\nPublic Class MyDBFileThumb\n    Implements IDBFileThumb\n    ' Implementation of IDBFileThumb members\nEnd Class