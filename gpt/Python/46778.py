class MockDiskInfoProvider(DiskInfoProvider):\n    def get_logical_disk_info(self):\n        return [{'DeviceID': 'C:', 'FreeSpace': 1000000000, 'Size': 2000000000}]