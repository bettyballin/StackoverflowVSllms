svnadmin dump https://svn.example.com/repo/trunk \\n       | svndumpfilter exclude path/to/exclude \\n       | svnadmin load /path/to/new/repo