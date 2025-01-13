public class HardwareMonitor\n{\n    private SerialPortCommunicator _communicator;\n    private bool _running;\n\n    public HardwareMonitor(SerialPortCommunicator communicator)\n    {\n        _communicator = communicator;\n    }\n\n    public void Start()\n    {\n        _running = true;\n        Task.Run(() => MonitorHardware());\n    }\n\n    public void Stop()\n    {\n        _running = false;\n    }\n\n    private async Task MonitorHardware()\n    {\n        while (_running)\n        {\n            // Check hardware status\n            await _communicator.SendCommandAsync("STATUS");\n            await Task.Delay(1000); // Adjust the delay as needed\n        }\n    }\n}