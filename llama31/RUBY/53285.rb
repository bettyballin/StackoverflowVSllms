require 'win32/registry'\n\n# Open the registry key for environment variables\nreg = Win32::Registry::HKEY_CURRENT_USER.open('Environment', Win32::Registry::KEY_WRITE)\n\n# Set the JAVA_HOME environment variable\nreg['JAVA_HOME'] = 'C:\path\to\java\home'\n\n# Close the registry key\nreg.close