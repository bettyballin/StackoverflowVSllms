require 'sys/registry'\n\nSys::Registry.set_value('HKEY_CURRENT_USER\Environment', 'JAVA_HOME', 'C:\path\to\java\home')