errno_t err = memcpy_s(dst, dst_len, src, in_len);\nif (err) {\n    // Handle error\n}