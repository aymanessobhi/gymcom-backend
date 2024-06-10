package com.ideracloud.gymcom.service.impl;

import com.ideracloud.gymcom.domain.Role;
import com.ideracloud.gymcom.repository.RoleRepository;
import com.ideracloud.gymcom.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Override
    public Role findByName(String name) {
        // Find role by name using the roleDao
        Role role = roleRepository.findByName(name);
        return role;
    }
}
