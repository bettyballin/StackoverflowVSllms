using System;\nusing System.IO;\nusing System.Windows;\nusing System.Windows.Controls;\nusing System.Windows.Media;\n\npublic class HexViewer : Control\n{\n    private FileStream _fileStream;\n    private byte[] _cache = new byte[1024 * 1024]; // 1MB cache\n    private int _cacheOffset;\n\n    public HexViewer(string filePath)\n    {\n        _fileStream = new FileStream(filePath, FileMode.Open, FileAccess.Read);\n    }\n\n    protected override void OnRender(DrawingContext dc)\n    {\n        base.OnRender(dc);\n\n        // Calculate the visible area\n        Rect visibleRect = new Rect(0, 0, ActualWidth, ActualHeight);\n\n        // Read the visible data from the file\n        byte[] data = ReadVisibleData(visibleRect);\n\n        // Render the data as a hex dump\n        dc.DrawText(new FormattedText(data.ToString(), CultureInfo.CurrentCulture, FlowDirection.LeftToRight, new Typeface("Consolas"), 12, Brushes.White));\n    }\n\n    private byte[] ReadVisibleData(Rect visibleRect)\n    {\n        int offset = (int)visibleRect.Y * 16; // assuming 16 bytes per row\n        int length = (int)visibleRect.Height * 16;\n\n        // Check the cache first\n        if (_cacheOffset <= offset && offset + length <= _cacheOffset + _cache.Length)\n        {\n            // Return the cached data\n            return _cache.Skip(offset - _cacheOffset).Take(length).ToArray();\n        }\n\n        // Read the data from the file\n        _fileStream.Seek(offset, SeekOrigin.Begin);\n        byte[] data = new byte[length];\n        _fileStream.Read(data, 0, length);\n\n        // Cache the data\n        Array.Copy(data, 0, _cache, _cacheOffset, length);\n        _cacheOffset = offset;\n\n        return data;\n    }\n}