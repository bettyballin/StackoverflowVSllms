#include <windows.h>

// Returns true if thread times could be queried and its results are usable,
// false otherwise. Error handling is minimal, considering throwing detailed
// exceptions instead of returning a simple boolean.
int get_remote_thread_times(DWORD thread_id, FILETIME *kernel_time, FILETIME *user_time)
{
  FILETIME creation_time = { 0 };
  FILETIME exit_time = { 0 };
  HANDLE thread_handle = OpenThread(THREAD_QUERY_INFORMATION, FALSE, thread_id);
  if (thread_handle == INVALID_HANDLE_VALUE) return 0;

  int success = GetThreadTimes(thread_handle, &creation_time, &exit_time, kernel_time, user_time) != 0;

  CloseHandle(thread_handle);
  return success;
}