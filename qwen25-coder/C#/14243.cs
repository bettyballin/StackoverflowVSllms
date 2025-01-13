using System;\nusing System.Web;\n\npublic class BandwidthThrottlingModule : IHttpModule\n{\n    public void Init(HttpApplication context)\n    {\n        context.BeginRequest += new EventHandler(OnBeginRequest);\n    }\n\n    private void OnBeginRequest(object sender, EventArgs e)\n    {\n        HttpContext context = ((HttpApplication)sender).Context;\n        \n        string ipAddress = context.Request.UserHostAddress;\n\n        // Example VPN IP Range: 10.0.0.0 to 10.255.255.255\n        if (IsVpnIp(ipAddress))\n        {\n            new ThrottleOutputStream(context.Response).StartThrottling(10 * 1024); // 10 KBps\n        }\n    }\n\n    private bool IsVpnIp(string ipAddress)\n    {\n        // Simple check for VPN IP range\n        return ipAddress.StartsWith("10.");\n    }\n\n    public void Dispose() { }\n}\n\npublic class ThrottleOutputStream : System.IO.Stream\n{\n    private readonly System.IO.Stream innerStream;\n    private readonly int bytesPerSecond;\n\n    public ThrottleOutputStream(System.Web.HttpResponse response) : this(response.OutputStream, 10 * 1024) {}\n\n    public ThrottleOutputStream(System.IO.Stream streamToWrap, int throttleLimitBytesPerSecond)\n    {\n        if (streamToWrap == null) throw new ArgumentNullException("streamToWrap");\n\n        innerStream = streamToWrap;\n        bytesPerSecond = throttleLimitBytesPerSecond;\n    }\n\n    public void StartThrottling(int byteRate)\n    {\n        bytesPerSecond =(byteRate > 0 ? byteRate : 1);\n    }\n\n    public override bool CanRead { get { return false; } }\n    public override bool CanSeek { get { return false; } }\n    public override bool CanWrite { get { return innerStream.CanWrite; } }\n    public override long Length { get { throw new NotSupportedException(); } }\n    public override long Position\n    {\n        get { return innerStream.Position; }\n        set { throw new NotSupportedException(); }\n    }\n\n    public override IAsyncResult BeginRead(byte[] buffer, int offset, int count, AsyncCallback callback, object state) { throw new NotSupportedException(); }\n    public override int EndRead(IAsyncResult asyncResult) { throw new NotSupportedException(); }\n    public override void Write(byte[] buffer, int offset, int count)\n    {\n        const int BufferSize = 4096;\n\n        for (long i = 0; i < count; i += BufferSize)\n        {\n            long remaining = count - i;\n            if (remaining > 0)\n                innerStream.Write(buffer, (int)(offset + i), (int)Math.Min(remaining, BufferSize));\n\n            System.Threading.Thread.Sleep((int)(((double)BufferSize / bytesPerSecond) * 1000));\n        }\n    }\n\n    public override void WriteByte(byte value) { throw new InvalidOperationException(); }\n    public override bool CanTimeout { get { return innerStream.CanTimeout; } }\n\n    protected override void Dispose(bool disposing)\n    {\n        if (disposing)\n            this.innerStream.Dispose();\n\n        base.Dispose(disposing);\n    }\n\n    public override void Flush() {}\n    public override long Seek(long offset, System.IO.SeekOrigin origin) { throw new NotSupportedException(); }\n    public override void SetLength(long value) { throw new NotSupportedException(); }\n}