// Example of creating a named pipe server
   HANDLE hPipe = CreateNamedPipe(
       TEXT("\\\\.\\pipe\\MyNamedPipe"), PIPE_ACCESS_DUPLEX,
       PIPE_TYPE_MESSAGE | PIPE_READMODE_MESSAGE | PIPE_WAIT,
       PIPE_UNLIMITED_INSTANCES, 512, 512, 0, NULL);

   if (hPipe == INVALID_HANDLE_VALUE) {
       // Handle error
   }

   // Wait for the client to connect
   BOOL connected = ConnectNamedPipe(hPipe, NULL) ? TRUE : (GetLastError() == ERROR_PIPE_CONNECTED);
   if (connected) {
       // Read and write data to the pipe
   }