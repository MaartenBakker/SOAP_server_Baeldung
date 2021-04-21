package repositories;

import com.baeldung.springsoap.gen.Country;
import com.baeldung.springsoap.gen.Currency;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country country = new Country();
        country.setName("Nederland");
        country.setCapital("Amsterdam");
        country.setCurrency(Currency.EUR);
        country.setPopulation(1000);

        countries.put(country.getName(), country);

        country = new Country();
        country.setName("UK");
        country.setCapital("London");
        country.setCurrency(Currency.GBP);
        country.setPopulation(5000);

        countries.put(country.getName(), country);
    }

    public Country findCountry(String name) {
        return countries.get(name);
    }
}
