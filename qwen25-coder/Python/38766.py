import time\nimport os\n\nclass MyService(win32serviceutil.ServiceFramework):\n    _svc_name_ = "MyPythonService"\n    _svc_display_name_ = "My Python Service"\n\n    def __init__(self, args):\n        win32serviceutil.ServiceFramework.__init__(self, args)\n        self.hWaitStop = win32event.CreateEvent(None, 0, 0, None)\n        self.command_file_path = os.path.join(os.path.expanduser('~'), 'service_command.txt')\n\n    def SvcDoRun(self):\n        import servicemanager\n        servicemanager.LogMsg(servicemanager.EVENTLOG_INFORMATION_TYPE,\n                              servicemanager.PYS_SERVICE_STARTED,\n                              (self._svc_name_, ''))\n        self.main()\n\n    def SvcStop(self):\n        self.ReportServiceStatus(win32service.SERVICE_STOP_PENDING)\n        win32event.SetEvent(self.hWaitStop)\n\n    def main(self):\n        while True:\n            rc = win32event.WaitForSingleObject(self.hWaitStop, 5000)\n            if rc == win32event.WAIT_OBJECT_0:\n                break\n            self.handle_commands()\n\n    def handle_commands(self):\n        if os.path.exists(self.command_file_path):\n            with open(self.command_file_path, 'r') as file:\n                command = file.read().strip()\n            print(f"Received command: {command}")\n            \n            # Clear the command after processing\n            open(self.command_file_path, 'w').close()\n\nif __name__ == '__main__':\n    win32serviceutil.HandleCommandLine(MyService)