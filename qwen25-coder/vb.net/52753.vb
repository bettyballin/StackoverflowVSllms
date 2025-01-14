' Define a named type for the tuples\nPublic Class ToolTuple\n    Public Property StationIndex As Integer\n    Public Property SlotNumber As Integer\nEnd Class\n\n' Use the named type in your queries\nDim loTupleDatabaseTools = From tt In lottTorqueTools\n                           Select New ToolTuple With {.StationIndex = tt.station_index, .SlotNumber = tt.slot_number}\n\nDim loTupleToolObjects = From tt In m_lottTorqueTools\n                         Select New ToolTuple With {.StationIndex = tt.StationIndex, .SlotNumber = tt.SlotNumber}\n\n' Now the types are the same and Except can be used\nDim loTupleSetDifference = loTupleDatabaseTools.Except(loTupleToolObjects)