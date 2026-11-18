package com.example.arithmetic.controller;

import com.example.arithmetic.service.ArithmeticService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ArithmeticController.class)
class ArithmeticControllerTest {
    @Autowired private MockMvc mockMvc;
    @MockBean private ArithmeticService arithmeticService;

    @Test
    void add_returnsSum() throws Exception {
        when(arithmeticService.add(10, 5)).thenReturn(15.0);
        mockMvc.perform(get("/api/add").param("a", "10").param("b", "5"))
                .andExpect(status().isOk()).andExpect(content().string("15.0"));
    }

    @Test
    void subtract_returnsDifference() throws Exception {
        when(arithmeticService.subtract(10, 5)).thenReturn(5.0);
        mockMvc.perform(get("/api/subtract").param("a", "10").param("b", "5"))
                .andExpect(status().isOk()).andExpect(content().string("5.0"));
    }

    @Test
    void multiply_returnsProduct() throws Exception {
        when(arithmeticService.multiply(10, 5)).thenReturn(50.0);
        mockMvc.perform(get("/api/multiply").param("a", "10").param("b", "5"))
                .andExpect(status().isOk()).andExpect(content().string("50.0"));
    }

    @Test
    void divide_returnsQuotient() throws Exception {
        when(arithmeticService.divide(10, 5)).thenReturn(2.0);
        mockMvc.perform(get("/api/divide").param("a", "10").param("b", "5"))
                .andExpect(status().isOk()).andExpect(content().string("2.0"));
    }

    @Test
    void divideByZero_returnsBadRequest() throws Exception {
        when(arithmeticService.divide(10, 0))
                .thenThrow(new IllegalArgumentException("Division by zero is not allowed"));
        mockMvc.perform(get("/api/divide").param("a", "10").param("b", "0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void addWithoutParameter_returnsBadRequest() throws Exception {
        mockMvc.perform(get("/api/add").param("a", "10"))
                .andExpect(status().isBadRequest());
    }
}
