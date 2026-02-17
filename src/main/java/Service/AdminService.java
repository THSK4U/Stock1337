package Service;

import Model.Admin;

import java.util.List;

public interface AdminService {

    Admin createAdmin(Admin admin);
    Admin getAdminById(Long id);
    List<Admin> getAllAdmins();
    Admin updateAdmin(Long id, Admin admin);
    void deleteAdmin(Long id);
    Admin getByEmail(String email);
}
