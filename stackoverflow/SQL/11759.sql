CREATE FUNCTION Test (@top integer)\n\nRETURNS TABLE\n\nAS\n\nSET ROWCOUNT @top\n\nRETURN SELECT * FROM SomeTable