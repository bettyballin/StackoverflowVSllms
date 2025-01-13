case "$host_os" in\n  aix*)         php_os="AIX";;\n  bsd*)         php_os="BSD";;\n  cygwin*)      php_os="CYGWIN_NT-$(uname -r)";;\n  darwin*)      php_os="Darwin";;\n  freebsd*)     php_os="FreeBSD";;\n  hpux*)        php_os="HP-UX";;\n  irix*)        php_os="IRIX64";;\n  linux*)       php_os="Linux";;\n  mingw*)       php_os="WINNT";;\n  netbsd*)      php_os="NetBSD";;\n  openbsd*)     php_os="OpenBSD";;\n  osf*)         php_os="OSF1";;\n  solaris*)     php_os="SunOS";;\n  sunos*)       php_os="SunOS";;\n  sysv5*)       php_os="Unix";;\n  unixware*)    php_os="UnixWare";;\n  windows*)     php_os="WINNT";;\n  *)\n    php_os="Unknown";\n    ;;\nesac