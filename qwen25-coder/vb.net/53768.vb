Protected Overrides Sub Finalize()\n    ' Call Dispose with false indicating that we are in the finalizer.\n    Dispose(False)\n    ' Call the base class's Finalize method.\n    MyBase.Finalize()\nEnd Sub