// Register for device connect notification\nDEV_BROADCAST_DEVICEINTERFACE devInt;\nZeroMemory(&devInt, sizeof(devInt));\ndevInt.dbcc_size = sizeof(DEV_BROADCAST_DEVICEINTERFACE);\ndevInt.dbcc_devicetype = DBT_DEVTYP_DEVICEINTERFACE;\ndevInt.dbcc_classguid = GUID_DEVINTERFACE_VOLUME;\n\nif (m_hDeviceNotify) {\n    UnregisterDeviceNotification(m_hDeviceNotify);\n}\n\nm_hDeviceNotify = RegisterDeviceNotification(winId(), &devInt, DEVICE_NOTIFY_WINDOW_HANDLE);\nif (!m_hDeviceNotify) {\n    qDebug() << "Device notification registration failed with error:" << GetLastError();\n}