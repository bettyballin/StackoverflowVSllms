require 'win32/api'\ninclude Win32\n\ndef get_unicode_filename(short_name)\n  long_name = "\0" * 1024\n  GetLongPathNameW(short_name, long_name, 1024)\n  long_name.strip\nend\n\nDir.foreach(dirname) do |short_name|\n  unicode_name = get_unicode_filename(short_name)\n  # process unicode_name\nend