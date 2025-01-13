using System;\nusing System.Runtime.InteropServices;\n\nclass Program\n{\n    [DllImport("winmm.dll")]\n    static extern uint timeSetEvent(uint uDelay, uint uResolution, TimerProc lpTimeProc, uint dwUser, uint fuEvent);\n\n    [DllImport("winmm.dll")]\n    static extern uint timeKillEvent(uint uTimerID);\n\n    delegate void TimerProc(uint uTimerID, uint uMsg, uint dwUser, uint dw1, uint dw2);\n\n    static void Main()\n    {\n        uint timerID = timeSetEvent(10, 0, TimerProc, 0, 0);\n\n        // ...\n\n        timeKillEvent(timerID);\n    }\n\n    static void TimerProc(uint uTimerID, uint uMsg, uint dwUser, uint dw1, uint dw2)\n    {\n        // trigger your procedure here\n        Console.WriteLine("Tick!");\n    }\n}