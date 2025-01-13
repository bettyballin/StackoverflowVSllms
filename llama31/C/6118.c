static void Compress(void *to, size_t to_size, void *from, size_t from_size, int *final_size)\n{\n    int ret;\n    z_stream stream;\n\n    stream.zalloc = Z_NULL;\n    stream.zfree = Z_NULL;\n    stream.opaque = Z_NULL;\n\n    if ((ret = deflateInit(&stream, CompressionSpeed)) != Z_OK)\n        COMPRESSION_ERROR("deflateInit() failed: %d", ret);\n\n    // Add the 2-byte header expected by IE8\n    char header[] = "\x78\x01";\n    memcpy(to, header, 2);\n\n    stream.next_out = (Bytef *)((char *)to + 2);\n    stream.avail_out = (uInt)to_size - 2;\n    stream.next_in = (Bytef *)from;\n    stream.avail_in = (uInt)from_size;\n\n    if ((ret = deflate(&stream, Z_NO_FLUSH)) != Z_OK)\n        COMPRESSION_ERROR("deflate() failed: %d", ret);\n\n    if (stream.avail_in != 0)\n        COMPRESSION_ERROR("stream.avail_in is not 0 (it's %d)", stream.avail_in);\n\n    if ((ret = deflate(&stream, Z_FINISH)) != Z_STREAM_END)\n        COMPRESSION_ERROR("deflate() failed: %d", ret);\n\n    // Add the 4-byte Adler-32 checksum at the end\n    uLong crc = adler32(0L, Z_NULL, 0);\n    crc = adler32(crc, (const Bytef *)from, from_size);\n    char footer[4];\n    footer[0] = (crc >> 24) & 0xFF;\n    footer[1] = (crc >> 16) & 0xFF;\n    footer[2] = (crc >> 8) & 0xFF;\n    footer[3] = crc & 0xFF;\n    memcpy((char *)to + stream.total_out + 2, footer, 4);\n\n    if ((ret = deflateEnd(&stream)) != Z_OK)\n        COMPRESSION_ERROR("deflateEnd() failed: %d", ret);\n\n    if (final_size)\n        *final_size = stream.total_out + 6; // 2-byte header + 4-byte footer\n\n    return;\n}