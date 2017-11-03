package ac.cr.una.lab2.dao;



import ac.cr.una.lab2.model.Role;

import java.util.List;

public interface RoleDao {
    Role findByAuthority(String authority);
    Role add(Role role);
    List<Role> listRoles();
}