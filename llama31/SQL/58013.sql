CREATE USER aspnet_membership_user FOR LOGIN = 'aspnet_membership_login' WITH DEFAULT_SCHEMA = 'dbo';\nGRANT db_datareader TO aspnet_membership_user;\nGRANT db_datawriter TO aspnet_membership_user;\nALTER ROLE db_owner ADD MEMBER aspnet_membership_user;