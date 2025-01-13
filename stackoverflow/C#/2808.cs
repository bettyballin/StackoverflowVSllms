private void BufferData(byte[] data, int offset, int size, bool needToCopyData)\n{\n    int num;\n    if (this._lastBuffer != null)\n    {\n        num = this._lastBuffer.Append(data, offset, size);\n        size -= num;\n        offset += num;\n    }\n    else if ((!needToCopyData && (offset == 0)) && !this._responseBufferingOn)\n    {\n        this._buffers.Add(new HttpResponseBufferElement(data, size));\n        return;\n    }\n    while (size > 0)\n    {\n        this._lastBuffer = this.CreateNewMemoryBufferElement();\n        this._buffers.Add(this._lastBuffer);\n        num = this._lastBuffer.Append(data, offset, size);\n        offset += num;\n        size -= num;\n    }\n}