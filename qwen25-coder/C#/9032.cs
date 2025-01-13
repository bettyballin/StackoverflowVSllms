public class ByteCountingStream : Stream\n{\n    private Stream _innerStream;\n    public long BytesWritten { get; private set; }\n\n    public ByteCountingStream(Stream inner)\n    {\n        _innerStream = inner;\n    }\n\n    public override void Write(byte[] buffer, int offset, int count)\n    {\n        _innerStream.Write(buffer, offset, count);\n        BytesWritten += count;\n    }\n\n    // Implement other required members of Stream\n    public override bool CanRead => _innerStream.CanRead;\n    public override bool CanSeek => _innerStream.CanSeek;\n    public override bool CanWrite => _innerStream.CanWrite;\n    public override long Length => _innerStream.Length;\n    public override long Position { get => _innerStream.Position; set => _innerStream.Position = value; }\n\n    public override void Flush()\n    {\n        _innerStream.Flush();\n    }\n\n    public override int Read(byte[] buffer, int offset, int count)\n    {\n        return _innerStream.Read(buffer, offset, count);\n    }\n\n    public override long Seek(long offset, SeekOrigin origin)\n    {\n        return _innerStream.Seek(offset, origin);\n    }\n\n    public override void SetLength(long value)\n    {\n        _innerStream.SetLength(value);\n    }\n}