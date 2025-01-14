SELECT \n    CONNECTIONPROPERTY('Net_transport') AS NetworkTransport,\n    CONNECTIONPROPERTY('protocol_version') AS ProtocolVersion,\n    CONNECTIONPROPERTY('auth_scheme') AS AuthenticationScheme,\n    @@servername AS ServerName,\n    SYSTEM_USER AS SystemUser;