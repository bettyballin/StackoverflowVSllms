CREATE INDEX idx_usergroup_nodeid ON viewpermission (viewpermission_usergroupID, viewpermission_nodeID);\n   CREATE INDEX idx_node_dates ON node (node_ID, node_lastupdated);