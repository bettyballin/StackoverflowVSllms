using System;\nusing System.Runtime.InteropServices;\nusing Microsoft.Office.Interop.MSProject;\n\nclass Program\n{\n    static void Main()\n    {\n        Application projectApp = new Application();\n        try\n        {\n            // Open the MS Project file\n            projectApp.FileOpen(@"C:\path\to\your\projectfile.mpp", false, Type.Missing, Type.Missing, Type.Missing, Type.Missing, Type.Missing, Type.Missing, Type.Missing, Type.Missing, Type.Missing, PjPoolOpen.pjPoolReadOnly, Type.Missing, Type.Missing, Type.Missing, Type.Missing);\n            \n            Project project = projectApp.ActiveProject;\n            \n            // Iterate through tasks\n            foreach (Task task in project.Tasks)\n            {\n                if (task != null)\n                {\n                    Console.WriteLine($"Task Name: {task.Name}, Start Date: {task.Start}, Finish Date: {task.Finish}");\n                }\n            }\n            \n            // Close the project\n            projectApp.FileCloseAll(PjSaveType.pjDoNotSave);\n        }\n        catch (COMException ex)\n        {\n            Console.WriteLine("Error: " + ex.Message);\n        }\n        finally\n        {\n            // Quit the application\n            projectApp.Quit(PjSaveType.pjDoNotSave);\n            Marshal.ReleaseComObject(projectApp);\n        }\n    }\n}