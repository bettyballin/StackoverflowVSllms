typedef struct {\n  WORD  wFormatTag;         /* format type */\n  WORD  nChannels;          /* number of channels (i.e. mono, stereo, etc.) */\n  DWORD nSamplesPerSec;     /* sample rate */\n  DWORD nAvgBytesPerSec;    /* for buffer estimation */\n  WORD  nBlockAlign;        /* block size of data */\n  WORD  wBitsPerSample;     /* number of bits per sample of mono data */\n  WORD  cbSize;             /* the count in bytes of the size of */\n} WAVEFORMATEX, *PWAVEFORMATEX, *LPWAVEFORMATEX;