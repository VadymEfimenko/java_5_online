package ua.com.alevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ua.com.alevel.config.security.AuthenticationService;
import ua.com.alevel.config.security.RegisterRequest;
import ua.com.alevel.persistence.sql.repository.user.AdminRepository;
import ua.com.alevel.persistence.sql.type.RoleType;

@SpringBootApplication
public class Main {

    @Autowired
    private AuthenticationService service;

//    @Autowired
//    private ExportCSVService exportCSVService;

    @Autowired
    private AdminRepository adminRepository;

//    @Autowired
//    private SyncSupplierService syncSupplierService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        String adminName = "admin@mail.com";
        if (!adminRepository.existsByUsername(adminName)) {
            var admin = RegisterRequest.builder()
                    .username(adminName)
                    .password("12345678")
                    .roleType(RoleType.ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());
        }
//        exportCSVService.export();

//        syncSupplierService.sync();
    }
}