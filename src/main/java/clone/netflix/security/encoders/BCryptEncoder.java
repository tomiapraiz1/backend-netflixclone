package clone.netflix.security.encoders;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptEncoder {

    private PasswordEncoder passwordEncoder;

    public BCryptEncoder() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return passwordEncoder;
    }
}
