-- This query retrieves some basic information about memory usage by SQL Express instance\nSELECT \n    (physical_memory_in_use_kb/1024) MemoryUsageMB,\n    (locked_page_allocations_kb/1024) LockedPagesUsageMB, \n    (virtual_address_space_commit_kb/1024) VirtualAddressSpaceCommitMB,\n    (virtual_address_space_reserved_kb/1024 ) VirtualAddressSpaceReservedMB, \n    (page_fault_count) PageFaultCount,\n    process_physical_memory_low\nFROM sys.dm_server_registry AS ServerRegistry;