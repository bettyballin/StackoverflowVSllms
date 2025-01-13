using System;\nusing System.Runtime.InteropServices;\nusing System.Windows.Forms;\nusing DirectShowLib;\n\npublic class CameraCapture : Form\n{\n    private const int WM_DEVICECHANGE = 0x0219;\n\n    [DllImport("user32.dll", CharSet = CharSet.Auto, SetLastError = true)]\n    public static extern IntPtr SendMessage(IntPtr hWnd, uint Msg, UIntPtr wParam, IntPtr lParam);\n\n    private VideoWindow videoWin;\n    private GraphBuilder graphBuilder;\n\n    public CameraCapture()\n    {\n        this.videoWin = (VideoWindow)new VideoWindowClass();\n        this.graphBuilder = (GraphBuilder)new FilterGraph();\n\n        SetupGraph();\n    }\n\n    void SetupGraph()\n    {\n        object source = null;\n        object renderer = new VideoRendererDefaultClass();\n        ICaptureGraphBuilder2 captureGraph = (ICaptureGraphBuilder2)new CaptureGraphBuilder2();\n        IBaseFilter videoInputDevice = (IBaseFilter)source;\n\n        int returnVal = 0;\n        Guid clsidCat = typeof(IAMStreamConfig).GUID;\n\n        if (captureGraph.SetFiltergraph(graphBuilder) < 0)\n            throw new ApplicationException("SetFiltergraph() failed");\n\n        if (deviceMoniker == null)\n        {\n            // No device has been selected yet. Use the first video capture device available.\n            DsDevice[] devices = DsDevice.GetDevicesOfCat(FilterCategory.VideoInputDevice);\n            if (devices.Length == 0) throw new ApplicationException("No video devices found");\n            deviceMoniker = devices[0].Mon;\n        }\n\n        // Add Camera to graph\n        returnVal = deviceMoniker.BindToObject(null, null, typeof(IBaseFilter).GUID, out source);\n        if (returnVal != 0)\n        {\n            ReleaseAll();\n            MessageBox.Show("Failed to bind to the video capture filter", "DirectShow Error",\n                MessageBoxButtons.OK, MessageBoxIcon.Stop);\n            return;\n        }\n\n        graphBuilder.AddFilter((IBaseFilter)source, "Video Capture");\n\n        // Add SampleGrabber to filtergraph\n        IBaseFilter sampleGrabber = (IBaseFilter)new SampleGrabber();\n        graphBuilder.AddFilter(sampleGrabber, "Sample Grabber");\n\n        ISampleGrabber sampGrabber = (ISampleGrabber)sampleGrabber;\n\n        // Set the media type of the sample grabber.\n        AMMediaType media = new AMMediaType();\n        returnVal = sampGrabber.GetConnectedMediaType(media);\n        if (returnVal == 0)\n        {\n            if ((media.majorType != MediaType.Video) || (media.formatType != FormatType.VideoInfo))\n                throw new ApplicationException("Unknown or incorrect media type from sample grabber");\n\n            // Configure the Sample Grabber\n            int hr = sampGrabber.SetBufferSamples(false);\n            DsError.ThrowExceptionForHR(hr);\n            media.mediaTypePtr = IntPtr.Zero;\n        }\n\n        IBaseFilter nullRenderer = (IBaseFilter)new NullRenderer();\n        graphBuilder.AddFilter(nullRenderer, "Null Renderer");\n\n        captureGraph.RenderStream(PinCategory.Capture, MediaType.Video, videoInputDevice,\n                                  sampleGrabber, nullRenderer);\n\n        // Setup the video window\n        this.videoWin.Owner = this.Handle;\n        this.videoWin.WindowStyle = WindowStyle.Child | WindowStyle.BorderStyleNone;\n        Rectangle rc = DisplayRectangle;\n        this.videoWin.SetWindowPosition(0, 0, rc.Width, rc.Height);\n        ((IVideoWindow)videoWin).SetAspectRatioMode(VideoAspectMode.LetterBox);\n        \n        ((IBaseFilter)sampleGrabber).Run();\n\n        // Run the graph.\n        returnVal = graphBuilder.Run();\n        DsError.ThrowExceptionForHR(returnVal);\n\n        // Stop all streams on a keystroke ('S' or 's').\n        this.KeyDown += new KeyEventHandler(this.OnKeyDown);\n    }\n\n    private void OnKeyDown(object sender, KeyEventArgs e)\n    {\n        if (e.KeyCode == Keys.S)\n            graphBuilder.Stop();\n    }\n\n    private void ReleaseAll()\n    {\n        Marshal.ReleaseComObject(graphBuilder);\n        Marshal.ReleaseComObject(videoWin);\n\n        videoWin = null;\n        graphBuilder = null;\n\n        GC.Collect(0);\n        GC.WaitForPendingFinalizers();\n        GC.Collect(1);\n    }\n}