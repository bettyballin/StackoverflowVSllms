$additionalPath = '/path/to/your/directory';\n$newIncludePath = get_include_path() . PATH_SEPARATOR . $additionalPath;\nset_include_path($newIncludePath);