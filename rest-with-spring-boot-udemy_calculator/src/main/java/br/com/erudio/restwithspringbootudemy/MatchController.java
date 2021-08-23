package br.com.erudio.restwithspringbootudemy;
import br.com.erudio.exception.UnsuportedMatchOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MatchController {


    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double sum(@PathVariable(value="numberOne") String numberOne,@PathVariable(value="numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMatchOperationException("Please set a numeric value!");
        }
        Double sum  =  converToDouble(numberOne) + converToDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value="numberOne") String numberOne,@PathVariable(value="numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMatchOperationException("Please set a numeric value!");
        }
        Double subtraction  =  converToDouble(numberOne) - converToDouble(numberTwo);
        return subtraction;
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double division(@PathVariable(value="numberOne") String numberOne,@PathVariable(value="numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMatchOperationException("Please set a numeric value!");
        }
        Double division  =  converToDouble(numberOne) / converToDouble(numberTwo);
        return division;
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value="numberOne") String numberOne,@PathVariable(value="numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMatchOperationException("Please set a numeric value!");
        }
        Double multiplication  =  converToDouble(numberOne) * converToDouble(numberTwo);
        return multiplication;
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double mean(@PathVariable(value="numberOne") String numberOne,@PathVariable(value="numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMatchOperationException("Please set a numeric value!");
        }
        Double mean  =  (converToDouble(numberOne) + converToDouble(numberTwo))/2;
        return mean;
    }

    @RequestMapping(value = "/squareRoot/{number}",method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value="number") String number)
            throws Exception {
        if (!isNumeric(number)) {
            throw new UnsuportedMatchOperationException("Please set a numeric value!");
        }
        Double squareRoot  =  Math.sqrt(converToDouble(number));
        return squareRoot;
    }

    private Double converToDouble(String number) {
        if (number == null) return 0d;
        String num = number.replaceAll(",", ".");
        if (isNumeric(num)) return Double.parseDouble(num);
        return 0d;

    }

    private boolean isNumeric(String number) {
        if (number == null) return false;
        String num = number.replaceAll(",", ".");
        return num.matches("[-+]?[0-9]*\\.?[0-9]+");

    }


}