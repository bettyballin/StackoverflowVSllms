function getLastModifiedTime(filePath) \n{\n    try \n    {\n        netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");\n    } \n    catch (e) \n    {\n        throw new Error("Permission to read file was denied.");\n    }\n\n    var file = Components.classes["@mozilla.org/file/local;1"]\n    .createInstance(Components.interfaces.nsILocalFile);\n\n    file.initWithPath( filePath );\n\n    return file.lastModifiedTime;\n}