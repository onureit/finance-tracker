package olzhas.nurseit.spring.services;

import olzhas.nurseit.spring.dtos.AuthRequestDTO;
import olzhas.nurseit.spring.dtos.AuthResponseDTO;
import olzhas.nurseit.spring.entities.Account;
import olzhas.nurseit.spring.repositories.AccountRepository;
import olzhas.nurseit.spring.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AccountRepository accountRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(AccountRepository accountRepository, JwtUtil jwtUtil) {
        this.accountRepository = accountRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Register
    public AuthResponseDTO register(AuthRequestDTO request) {
        // Check if username already exists
        if (accountRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already taken");
        }

        // Create new account
        Account account = new Account();
        account.setUsername(request.getUsername());
        account.setPassword(passwordEncoder.encode(request.getPassword())); // hash password

        accountRepository.save(account);

        // Generate token and return
        String token = jwtUtil.generateToken(account.getUsername());
        return new AuthResponseDTO(token, account.getUsername());
    }

    // Login
    public AuthResponseDTO login(AuthRequestDTO request) {
        // Find account by username
        Account account = accountRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Username not found"));

        // Check password
        if (!passwordEncoder.matches(request.getPassword(), account.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        // Generate token and return
        String token = jwtUtil.generateToken(account.getUsername());
        return new AuthResponseDTO(token, account.getUsername());
    }
}