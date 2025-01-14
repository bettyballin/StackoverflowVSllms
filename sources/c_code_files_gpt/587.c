HANDLE OpenFileById(
      HANDLE                hVolumeHint,
      LPFILE_ID_DESCRIPTOR  lpFileId,
      DWORD                 dwDesiredAccess,
      DWORD                 dwShareMode,
      LPSECURITY_ATTRIBUTES lpSecurityAttributes,
      DWORD                 dwFlagsAndAttributes
    );