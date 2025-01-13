Function VolatileRead(Of T)(ByRef Address As T) As T\n    VolatileRead = Address\n    Threading.Thread.MemoryBarrier()\nEnd Function\n\nSub VolatileWrite(Of T)(ByRef Address As T, ByVal Value As T)\n    Threading.Thread.MemoryBarrier()\n    Address = Value\nEnd Sub