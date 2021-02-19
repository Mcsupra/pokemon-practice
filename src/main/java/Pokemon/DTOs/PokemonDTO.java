package Pokemon.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class PokemonDTO {
    private String base_experience;
    private String name;
    GameIndexDTO[] game_indices;
}
