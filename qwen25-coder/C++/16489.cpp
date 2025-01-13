// Example using libarchive to add a file to an archive\n   #include <archive.h>\n   #include <archive_entry.h>\n   #include <iostream>\n\n   int main() {\n       struct archive* a = archive_write_new();\n       archive_write_set_filter_gzip(a);\n       archive_write_set_format_zip(a);\n       archive_write_open_filename(a, "filename.zip", 1024);\n\n       struct archive_entry *entry = archive_entry_new();\n       archive_entry_copy_sourcepath(entry, "file_to_add.txt");\n       archive_entry_set_filetype(entry, AE_IFREG);\n       archive_entry_set_size(entry, 1024); // replace with actual file size\n       archive_entry_set_mode(entry, S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH);\n\n       archive_write_header(a, entry);\n\n       char buffer[1024];\n       std::ifstream input("file_to_add.txt", std::ios::binary);\n       while (input.read(buffer, sizeof(buffer))) {\n           archive_write_data(a, buffer, input.gcount());\n       }\n\n       archive_entry_free(entry);\n       archive_write_finish_entry(a);\n       archive_write_close(a);\n       archive_write_free(a);\n\n       return 0;\n   }