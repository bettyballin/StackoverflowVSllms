import libxml2\nimport libxslt\n\n# Get version for libxml2\nlibxml2_version = libxml2.LIBXML_VERSION\nprint(f"libxml2 version: {libxml2_version}")\n\n# Convert the numeric version to a string format if needed\nmajor = libxml2_version >> 16\nminor = (libxml2_version >> 8) % 256\nrelease = libxml2_version % 256\nprint(f"libxml2 version: {major}.{minor}.{release}")\n\n# Get version for libxslt\nlibxslt_version = libxslt.LIBXSLT_VERSION\nprint(f"libxslt version: {libxslt_version}")\n\n# Convert the numeric version to a string format if needed\nmajor = libxslt_version >> 8\nrelease = libxslt_version % 256\nprint(f"libxslt version: {major}.{release}")