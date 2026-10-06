package co.edu.uptc.calculator.service;

import org.springframework.stereotype.Service;

import co.edu.uptc.calculator.dto.CalculatorDTO;
import co.edu.uptc.calculator.dto.ResponseDTO;
import co.edu.uptc.calculator.exceptions.DivisionByZeroException;
import co.edu.uptc.calculator.exceptions.InvalidOperationException;

@Service
public class CalculatorService {

    public ResponseDTO calculate(CalculatorDTO calculator) {

        double num1 = calculator.getNum1();
        double num2 = calculator.getNum2();
        String operation = calculator.getOperation().toLowerCase();

        double result;

        switch (operation) {

            case "suma":
                result = num1 + num2;
                break;

            case "resta":
                result = num1 - num2;
                break;

            case "multiplicacion":
                result = num1 * num2;
                break;

            case "division":

                if (num2 == 0) {
                    throw new DivisionByZeroException(
                        "No se puede dividir entre cero"
                    );
                }

                result = num1 / num2;
                break;

            default:
                throw new InvalidOperationException(
                    "Operación no válida: " + operation
                );
        }

        return new ResponseDTO(
            num1 + " " + operation + " " + num2,
            result,
            "Operación realizada correctamente"
        );
    }
}