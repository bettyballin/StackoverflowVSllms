static string jniErrors;\n\nstatic jint JNICALL my_vfprintf(FILE *fp, const char *format, va_list args)\n{\n    char buf[1024];\n    vsnprintf(buf, sizeof(buf), format, args);\n    jniErrors += buf;\n    return 0;\n}\n\n...\n\nJavaVMOption options[1];\noptions[0].optionString = "vfprintf";\noptions[0].extraInfo = my_vfprintf;\n\nJavaVMInitArgs vm_args;\nmemset(&vm_args, 0, sizeof(vm_args));\nvm_args.nOptions = 1;\nvm_args.options = options;\nvm_args.version = JNI_VERSION_1_4;\nvm_args.ignoreUnrecognized = JNI_FALSE;\n\nJNIEnv env;\nJavaVM jvm;\n\njint res = JNI_CreateJavaVM(&jvm, (void**)&env, &vm_args);\n\nif (res != JNI_OK)\n    setError(jniErrors);\n\njniErrors.clear();