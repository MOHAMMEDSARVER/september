package day22;

interface Currency {
    String getSymbol();
}

class India implements Currency {

    @Override
    public String getSymbol() {
        return "Rs";
    }
}

class USA implements Currency {

    @Override
    public String getSymbol() {
        return "&";
    }
}

class UK implements Currency {

    @Override
    public String getSymbol() {
        return "£";
    }
}

enum CountryCodes {
    IND, USA, UK
}

public class FactoryMethodExample {
    public static void main(String[] args) {
        Currency currency = getInstance(CountryCodes.USA);
        System.out.println(currency.getSymbol());

    }

    private static Currency getInstance(CountryCodes countryCodes) {
        switch (countryCodes) {
            case IND :
                return new India();
            case UK :
                return new UK();
            case USA:
                return new USA();
            default: throw new IllegalArgumentException("Invalid country code");

        }
    }
}
