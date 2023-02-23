package fr.univavignon.pokedex.api;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {



    /*@Before
    public void setUpClass(){
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
    }*/

    @Test
    public void getPokemonMetadataTest() throws PokedexException {
        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        PokemonMetadata pokemonMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(pokemonMetadata);
        pokemonMetadataProvider.getPokemonMetadata(133);
    }


}
