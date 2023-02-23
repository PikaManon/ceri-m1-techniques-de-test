package fr.univavignon.pokedex.api;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    static IPokemonMetadataProvider pokemonMetadataProvider;
    static PokemonMetadata aqualiMetadata;
    static PokemonMetadata bulbizarreMetadata;


    @BeforeClass
    public static void setUpClass(){
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre",126,126,90);
    }

    @Test
    public void getBulbizarreMetadataTest() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(bulbizarreMetadata);
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(0).getIndex(), bulbizarreMetadata.getIndex());
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(0).getName(), bulbizarreMetadata.getName());
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(0).getAttack(), bulbizarreMetadata.getAttack());
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(0).getDefense(), bulbizarreMetadata.getDefense());
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(0).getStamina(), bulbizarreMetadata.getStamina());
    }

    @Test
    public void getAqualiMetadataTest() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(aqualiMetadata);
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(133).getIndex(), aqualiMetadata.getIndex());
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(133).getName(), aqualiMetadata.getName());
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(133).getAttack(), aqualiMetadata.getAttack());
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(133).getDefense(), aqualiMetadata.getDefense());
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(133).getStamina(), aqualiMetadata.getStamina());
    }

    @Test
    public void exceptionMetadataTest() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(151)).thenThrow(new PokedexException("this pokemon's index doesn't exist"));
        Assert.assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(151));
    }



}
