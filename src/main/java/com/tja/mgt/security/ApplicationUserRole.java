package com.tja.mgt.security;

import java.util.Set;
import com.google.common.collect.Sets;
import static  com.tja.mgt.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
	USER(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(ADMIN_READ, ADMIN_WRITE, USER_READ));
	
	
	private final Set<ApplicationUserPermission> permission;

	private ApplicationUserRole(Set<ApplicationUserPermission> permission) {
		this.permission = permission;
	}

	public Set<ApplicationUserPermission> getPermission() {
		return permission;
	}
	

}
