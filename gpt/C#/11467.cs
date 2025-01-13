private void Window_MouseMove(object sender, MouseEventArgs e)\n{\n    Point mousePosition = e.GetPosition(this);\n    List<UIElement> elementsUnderMouse = new List<UIElement>();\n\n    VisualTreeHelper.HitTest(this, null,\n        new HitTestResultCallback(\n            result =>\n            {\n                if (result.VisualHit is UIElement element)\n                {\n                    elementsUnderMouse.Add(element);\n                }\n                return HitTestResultBehavior.Continue;\n            }),\n        new PointHitTestParameters(mousePosition));\n\n    // elementsUnderMouse now contains all UIElements under the mouse cursor\n}