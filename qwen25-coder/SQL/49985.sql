-- Ensure role is granted to the user\nGRANT your_role TO your_user;\n\n-- Check if roles are enabled in the session\n-- This can be done by running:\nSHOW USER; -- To confirm you're logged in as the expected user\nSET ROLE ALL; -- Enable all roles for the current sessio