// Compile and link\ntcc -c -tiny yourcode.c\ntlink /tiny yourcode.obj\n\n// Convert to .com\nexe2bin /F yourcode.exe yourcode.com