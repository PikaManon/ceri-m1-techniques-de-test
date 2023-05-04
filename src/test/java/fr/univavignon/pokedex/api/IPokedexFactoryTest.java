package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    static IPokemonMetadataProvider pokemonMetadataProvider;
    static IPokemonFactory pokemonFactory;
    static IPokedexFactory pokedexFactory;
    static IPokedex pokedex;

    @BeforeClass
    public static void setUpClass(){
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        //pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokedex = Mockito.mock(IPokedex.class);

        pokedexFactory = new PokedexFactory();
        pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
    }

    @Test
    public void createPokedexTest(){
        /*when(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory)).thenReturn(pokedex);*/

        Assert.assertEquals(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory).size(), 0);



    }

}
