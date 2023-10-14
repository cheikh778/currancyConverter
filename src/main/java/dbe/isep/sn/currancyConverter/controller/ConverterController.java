package dbe.isep.sn.currancyConverter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConverterController {

    @GetMapping("/currency/{value}/{devise}")
    public ResponseEntity<String> getConversion(@PathVariable int value, @PathVariable("devise") String targetCurrency) {
        int taux = 1;
        Double conversionResult = 0.0;
        String message = "";

        switch (targetCurrency) {
            case "USD": {
                taux = 550;
                conversionResult = (double) value / taux;
                message = "La conversion de " + value + "FCFA en " + targetCurrency + " est : " + conversionResult + "$";
                break;
            }

            case "EUR": {
                taux = 650;
                conversionResult = (double) value / taux;
                message = "La conversion de " + value + "FCFA en " + targetCurrency + " est : " + conversionResult + "€";
                
                break;


            }
            default: {
                return new ResponseEntity<>("Devise non prise en charge", HttpStatus.BAD_REQUEST);
            }
        }

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}