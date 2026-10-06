package co.edu.uptc.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.calculator.dto.CalculatorDTO;
import co.edu.uptc.calculator.dto.ResponseDTO;
import co.edu.uptc.calculator.service.CalculatorService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculator")
    public ResponseDTO calculate(
            @ModelAttribute CalculatorDTO calculator,
            HttpServletRequest request) {

        String ip = request.getHeader("X-Real-IP");

        if (ip == null) {
            ip = request.getRemoteAddr();
        }

        String container = System.getenv("CONTAINER_NAME");

        ResponseDTO response = calculatorService.calculate(calculator);

        response.setIp(ip);
        response.setNameContainer(container);

        return response;
    }
}