package id.ac.ifunjani.sistemreservasiklinik.controller;

import com.example.klinik.dto.LoginRequest;
import com.example.klinik.dto.RegisterPasienRequest;
import com.example.klinik.entity.Dokter;
import com.example.klinik.entity.Pasien;
import com.example.klinik.entity.Staff;
import com.example.klinik.service.AuthService;
import com.example.klinik.service.PasienService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    private final AuthService authService;
    private final PasienService pasienService;

    public AuthController(AuthService authService, PasienService pasienService) {
        this.authService = authService;
        this.pasienService = pasienService;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(
            @ModelAttribute LoginRequest request,
            Model model,
            HttpSession session) {

        String role = request.getRole();
        String id = request.getId();
        String password = request.getPassword();

        if ("pasien".equals(role)) {
            Pasien pasien = authService.loginPasien(id, password);
            if (pasien == null) {
                model.addAttribute("error", "ID atau password pasien tidak sesuai.");
                return "login";
            }
            session.setAttribute("ROLE", "PASIEN");
            session.setAttribute("USER_ID", pasien.getIdPasien());
            return "redirect:/pasien/dashboard";

        } else if ("dokter".equals(role)) {
            Dokter dokter = authService.loginDokter(id, password);
            if (dokter == null) {
                model.addAttribute("error", "Dokter tidak ditemukan.");
                return "login";
            }
            session.setAttribute("ROLE", "DOKTER");
            session.setAttribute("USER_ID", dokter.getIdDokter());
            return "redirect:/dokter/dashboard";

        } else if ("staff".equals(role)) {
            Staff staff = authService.loginStaff(id, password);
            if (staff == null) {
                model.addAttribute("error", "ID atau password staff tidak sesuai.");
                return "login";
            }
            session.setAttribute("ROLE", "STAFF");
            session.setAttribute("USER_ID", staff.getIdStaff());
            return "redirect:/staff/dashboard";
        }

        model.addAttribute("error", "Role tidak dikenal.");
        return "login";
    }

    @GetMapping("/register/pasien")
    public String showRegisterPasien(Model model) {
        model.addAttribute("registerRequest", new RegisterPasienRequest());
        return "register-pasien";
    }

    @PostMapping("/register/pasien")
    public String doRegisterPasien(
            @ModelAttribute RegisterPasienRequest request,
            Model model) {
        
        if (request.getIdPasien() == null || request.getIdPasien().length() != 16) {
            model.addAttribute("error", "ID Pasien (NIK) harus 16 digit.");
            return "register-pasien";
        }

        pasienService.registerPasien(request);
        model.addAttribute("success", "Akun pasien berhasil dibuat. Silakan login.");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
