USE msdb;\n   GO\n   -- Create a credential\n   CREATE CREDENTIAL MyCredential WITH IDENTITY = 'Domain\User', SECRET = 'password';\n   GO\n   -- Create a proxy\n   EXEC sp_add_proxy \n       @proxy_name = 'MyProxy', \n       @credential_name = 'MyCredential';\n   GO\n   -- Grant the proxy access to the CmdExec subsystem\n   EXEC sp_grant_proxy_to_subsystem \n       @proxy_name = 'MyProxy', \n       @subsystem_id = 2; -- 2 for CmdExec\n   GO