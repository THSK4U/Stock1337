package Service.Impl;


import Enums.Role;
import Model.Admin;
import Repository.AdminRepository;
import Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin createAdmin(Admin admin) {
        admin.setRole(Role.ADMIN);
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("No Admin found with id: " + id));
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin updateAdmin(Long id, Admin admin) {

        Admin existAdmin = getAdminById(id);
        existAdmin.setName(admin.getName());
        existAdmin.setEmail(admin.getEmail());
        existAdmin.setPassword(admin.getPassword());
        return adminRepository.save(existAdmin);
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Admin getByEmail(String email) {
        return adminRepository.findByEmail(email)
                .orElseThrow( () -> new RuntimeException("No Admin found with email: " + email));
    }




}
