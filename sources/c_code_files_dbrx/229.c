// Comlib attribute example
[ComlibName('MyLib.dll'), Guid('32C0DE6154187593E630BA51A9B68257')]
type
  MyLibrary = interface(IUnknown) ['{FD1FBFDA-2DBA-4E47-BFAB-EEDCDAFA70A9}'] procedure Foo; // Add other members here };