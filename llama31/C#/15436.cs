WaitHandle handle = ...;\nTimeSpan timeout = ...;\nbool signaled = handle.WaitOne(timeout, true); // pass true for exitContext