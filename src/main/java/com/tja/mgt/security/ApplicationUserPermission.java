package com.tja.mgt.security;

public enum ApplicationUserPermission {
  USER_READ("user:read"),
  ADMIN_READ("admin:read"),
  ADMIN_WRITE("admin:write");


private final String permission;

private ApplicationUserPermission(String permission) {
	this.permission = permission;
}

public String getPermission() {
	return permission;
}

}
