package Pokemon.PokeAPIServices;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Pokemon.Configurations.PokeAPIEnv;

@Service
public class PokemonService {

    private final RestTemplate restTemplate;

    public PokemonService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
            .setConnectTimeout(Duration.ofSeconds(30))
            .setReadTimeout(Duration.ofSeconds(30))
            .build();
    }

    public String getPostsPlainJSON(String id) {
        String url = PokeAPIEnv.POKE_URL+"pokemon/"+id;
        return this.restTemplate.getForObject(url, String.class);
    }
}
