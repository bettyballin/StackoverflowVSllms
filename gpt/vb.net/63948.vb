Dim xml = <Root>\n            <Parent id="1">\n              <Child>Thomas</Child>\n            </Parent>\n            <Parent id="2">\n              <Child>Tim</Child>\n              <Child>Jamie</Child>\n            </Parent>\n          </Root>\n\nDim parents = xml.<Parent>\n\nFor Each parent In parents\n    Console.WriteLine(parent)\nNext