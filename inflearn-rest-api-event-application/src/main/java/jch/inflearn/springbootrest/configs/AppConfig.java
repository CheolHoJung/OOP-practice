package jch.inflearn.springbootrest.configs;

import jch.inflearn.springbootrest.accounts.Account;
import jch.inflearn.springbootrest.accounts.AccountRole;
import jch.inflearn.springbootrest.accounts.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class AppConfig {

    @Autowired
    AccountService accountService;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> accountService.save(Account.builder()
                    .email("jcheolho.dev@gmail.com")
                    .password("jch")
                    .roles(Set.of(AccountRole.ADMIN, AccountRole.USER))
                    .build());
    }
}
