import clr\nclr.AddReference('System')\nfrom System import DateTime\nfrom System.Runtime.InteropServices import COMException\n\n# Example handling COMException\ntry:\n    # Your COM interaction code here\n    pass\nexcept COMException as com_ex:\n    print(f"COM Exception occurred: {com_ex}")\n\n# Example working with DateTime\ntime_now = DateTime.Now\nprint(f"Current time: {time_now}")