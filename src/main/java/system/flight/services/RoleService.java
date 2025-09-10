package system.flight.services;

import system.flight.dto.RolesDTO;

import java.util.List;

public interface RoleService {

	public List<RolesDTO> getAllRoles();

	public RolesDTO getRoleById(int id);

	public RolesDTO updateRole(int id, RolesDTO updatedRoleDTO);

	public void deleteRole(int id);

}
