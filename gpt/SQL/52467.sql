-- Step 1: Create the profile with resource limits\nCREATE PROFILE resource_limited_profile LIMIT\n  CPU_PER_CALL         1000         -- CPU time limit in hundredths of seconds\n  LOGICAL_READS_PER_CALL 10000      -- Number of data blocks read per call\n  COMPOSITE_LIMIT       5000000;    -- Composite limit including CPU, reads, etc.\n\n-- Step 2: Assign the profile to a user\nALTER USER username PROFILE resource_limited_profile;\n\n-- Step 3: Monitor and Adjust\n-- Use DBA_PROFILES and DBA_USERS to monitor profile usage and adjust as necessary\nSELECT * FROM DBA_PROFILES WHERE PROFILE = 'RESOURCE_LIMITED_PROFILE';\nSELECT USERNAME, PROFILE FROM DBA_USERS WHERE PROFILE = 'RESOURCE_LIMITED_PROFILE';