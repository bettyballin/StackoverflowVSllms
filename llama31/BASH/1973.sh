# Create a new label for the release\ntfpt label /server:http://tfs-server:8080/tfs /label:Release_1.0 /recursive /collection:MyCollection\n\n# Check-in changes with comments that include the version number\ntfpt checkin /server:http://tfs-server:8080/tfs /recursive /comment:"Fixed bug in release 1.0" /collection:MyCollectio