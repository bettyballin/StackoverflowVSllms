# Example: Simulate play/pause with Media Center using PowerShell\nAdd-Type -AssemblyName System.Windows.Forms\n\n[System.Windows.Forms.SendKeys]::SendWait("^{PAUSE}")  # ^{PAUSE} simulates Ctrl+Pause which typically toggles play/pause in many media players