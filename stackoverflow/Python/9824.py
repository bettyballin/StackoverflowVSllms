# Try to use the C implementation first, falling back to python\ntry:\n    from xml.etree import cElementTree as ElementTree\nexcept ImportError, e:\n    from xml.etree import ElementTree