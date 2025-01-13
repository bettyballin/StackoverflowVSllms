# Install necessary packages\nsudo apt-get install selinux-basics selinux-policy-default auditd audisp-plugins\n\n# Enable SELinux in enforcing mode\nsestatus  # Check current status\nsudo setenforce 1\ngetenforce  # Should print 'Enforcing'\n\n# Create a custom SELinux policy to restrict root access (example)\ncat << EOF > /tmp/my_restriction_policy.te\nmodule my_restriction_policy 1.0;\n\nrequire {\n    type init_t;\n    class process { execmem };\n}\n\nallow init_t self:process execmem;\nEOF\n\n# Compile and install the policy\ncheckmodule -M -m -o /tmp/my_restriction_policy.mod /tmp/my_restriction_policy.te\nsemodule_package -o my_restriction_policy.pp -m /tmp/my_restriction_policy.mod\nsudo semodule -i my_restriction_policy.pp