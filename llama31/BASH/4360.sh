# On the client repository\ngit format-patch -o /path/to/patches origin/master\n\n# On the temporary recovery repository\ngit apply /path/to/patches/*.patch