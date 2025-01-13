SELECT \n    cpu_usage = (SELECT AVG(value) FROM sys.dm_os_ring_buffers WHERE ring_buffer_type = 'CPU')\nFROM \n    sys.dm_os_ring_buffers\nWHERE \n    ring_buffer_type = 'CPU'\nORDER BY \n    timestamp DESC;