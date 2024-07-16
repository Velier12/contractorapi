package ru.fiarr4ik.contractorapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.fiarr4ik.contractorapi.controllers.CountryController;
import ru.fiarr4ik.contractorapi.services.CountryService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
    public class ControllerTests {

        @Mock
        private CountryService countryService;

        @InjectMocks
        private CountryController countryController;

        private MockMvc mockMvc;

        @BeforeEach
        void setUp(){
            mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();
        }

        @Test
        @DisplayName("Получение всех стран")
        void controllerGetAllIsWorked() throws Exception {
            mockMvc.perform(get("/country/all"))
                    .andExpect(status().isOk());
        }

        @Test
        @DisplayName("Получение страны по id")
        void controllerGetByIdIsWorked() throws Exception {
            mockMvc.perform(get("/country/{id}","RUS"))
                    .andExpect(status().isOk());
        }
    }
