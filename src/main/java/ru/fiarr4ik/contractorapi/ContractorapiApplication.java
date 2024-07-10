package ru.fiarr4ik.contractorapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "ContractorApi",
                description = "Spring boot REST API (contractor) для работы с контрагентами финтех приложения",
                version = "0.0.1",
                contact = @Contact(
                        name = "Fiarr4ikDev",
                        email = "fiarr4ikdev@gmail.com"
                )
        )
)
public class ContractorapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContractorapiApplication.class, args);
    }

}
