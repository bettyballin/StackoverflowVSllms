$command = "net use \\\\serverB\\sharedfolder /user:domain\\username password";\n   exec($command);\n   $object->Output('\\\\serverB\\sharedfolder\\file.dummy');