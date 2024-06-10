package com.ideracloud.gymcom.service;

import com.ideracloud.gymcom.domain.Role;

public interface RoleService {
    // Method to find a Role by its name
    Role findByName(String name);
}
