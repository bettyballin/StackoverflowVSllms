function clone_object($obj) {\n    return unserialize(serialize($obj));\n}