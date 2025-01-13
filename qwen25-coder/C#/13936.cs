try {\n    // Remoting call here\n} catch (SerializationException ex) {\n    EventLog.WriteEntry("Application", "Serialization Exception: " + ex.Message + "\n" + ex.StackTrace, EventLogEntryType.Error);\n} catch (Exception ex) {\n    EventLog.WriteEntry("Application", "General Exception: " + ex.Message + "\n" + ex.StackTrace, EventLogEntryType.Error);\n}