package tourstApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tourstApp.model.Role;
import tourstApp.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Role findById(Long id) {
        return this.roleRepository.getRoleById(id);
    }
    public Role findByName(String name) {
        return this.roleRepository.findByName(name);
    }
}
