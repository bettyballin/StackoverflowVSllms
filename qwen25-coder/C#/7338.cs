public partial class MainForm : Form, IMultiLanguage\n{\n    private CancellationTokenSource cancellationTokenSource;\n\n    // This method is subscribed to the event of pressing the 'Abort' button\n    private void StopCurrentAnalisis()\n    {\n        try\n        {\n            cancellationTokenSource?.Cancel();\n        }\n        catch (Exception e)\n        {\n            // Log exception if needed\n        }\n        finally\n        {\n            MessageBox.Show("Analysis has been cancelled by user", "Analysis Interrupted", MessageBoxButtons.OK, MessageBoxIcon.Stop);\n            CerrarNowLoadingForm();\n        }\n    }\n}\n\npublic class AnalisisManager : IAnalisisManagerController\n{\n    private Thread analisisThread;\n    public CancellationTokenSource CancellationTokenSource { get; set; }\n\n    public void MakePadrobAnalisis(TipoAnalisis tipoAnalisis, Dictionary<string, Dictionary<int, double>> parametros)\n    {\n        cancellationTokenSource = new CancellationTokenSource();\n        CancellationToken token = cancellationTokenSource.Token;\n\n        object[] arregloParams = new object[] { tipoAnalisis, parametros, token };\n        analisisThread = new Thread(new ParameterizedThreadStart(MakeAnalisisInOtherThread));\n        analisisThread.Start(arregloParams);\n    }\n\n    private void MakeAnalisisInOtherThread(object o)\n    {\n        object[] arregloParams = o as object[];\n        TipoAnalisis tipoAnalisis = (TipoAnalisis)arregloParams[0];\n        Dictionary<string, Dictionary<int, double>> parametros = arregloParams[1] as Dictionary<string, Dictionary<int, double>>;\n        CancellationToken token = (CancellationToken)arregloParams[2];\n\n        // This launches an event telling the GUI the unstable analysis has started.\n        StartAnalisis();\n\n        try\n        {\n            switch (tipoAnalisis)\n            {\n                case InvKinematicsMinTorque:\n                    if (!token.IsCancellationRequested)\n                        WrapperPadirob.InverseKinematicsMinTorqueConfigAnalisis();\n                    break;\n                // Add other cases as needed and check token.IsCancellationRequested before executing each DLL function\n            }\n        }\n        catch (OperationCanceledException)\n        {\n            // Handle cancellation if necessary\n        }\n    }\n}