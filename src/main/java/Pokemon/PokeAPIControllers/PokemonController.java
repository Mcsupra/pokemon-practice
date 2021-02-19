package Pokemon.PokeAPIControllers;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Pokemon.DTOs.PokemonDTO;
import Pokemon.PokeAPIServices.PokemonService;

@RestController
@RequestMapping("pokemon")
@CrossOrigin
public class PokemonController {

    ObjectMapper mapper = new ObjectMapper();
    private PokemonService pokeService;

    @Autowired
    public PokemonController (PokemonService pokeService){
        super();
        this.pokeService = pokeService;
    }

    @GetMapping("{id}")
    public PokemonDTO getCharmander(@PathVariable(name="id") String id){
        try{
            String returnedPokemon = pokeService.getPostsPlainJSON(id);
            PokemonDTO toPokemon = mapper.readValue(returnedPokemon, PokemonDTO.class);
             return toPokemon;
            // return null;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
