package app.Validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class InputsValidator {
    public void stringValidator(String string, String element) throws Exception {
        if (string == null || string.equals("")) {
            throw new Exception(element + " no es un valor valido");
        }
    }

    public int integerValidator(String number, String element) throws Exception {
        stringValidator(number, element);
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new Exception(element + " no es un numero valido");
        }
    }
    
    public long longValidator(String number, String element) throws Exception {

        try {
            return Long.parseLong(number);
        } catch (Exception e) {
            throw new Exception(element + " no es un numero valido");
        }
    }
    
    public double doubleValidator(String number, String element) throws Exception {
        longValidator(number, element);
        try {
            return Double.parseDouble(number);
        } catch (Exception e) {
            throw new Exception(element + " no es un numero valido");
        }
    }

    public Date dateValidator(String dateStr, String element) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new Exception(element + " no es una fecha válida en el formato yyyy-MM-dd");
        }
    }

}
