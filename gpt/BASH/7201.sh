# Find suspicious functions or base64 encoded content\nfind . -type f -name '*.php' -exec grep -EHn 'eval|base64_decode|shell_exec|system|passthru|popen' {} \;