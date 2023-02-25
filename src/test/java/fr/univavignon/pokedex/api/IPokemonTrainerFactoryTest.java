package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    static PokemonTrainer pokemonTrainer;
    static IPokedex pokedex;
    static IPokedexFactory pokedexFactory;
    static IPokemonTrainerFactory pokemonTrainerFactory;

    @BeforeClass
    public static void setUpClass(){
        pokedex = Mockito.mock(IPokedex.class);
        pokemonTrainer = new PokemonTrainer("Manon", Team.MYSTIC, pokedex);
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
    }

    @Test
    public void createTrainerTest(){
        when(pokemonTrainerFactory.createTrainer("Manon", Team.MYSTIC, pokedexFactory)).thenReturn(pokemonTrainer);
        Assert.assertEquals(pokemonTrainerFactory.createTrainer("Manon", Team.MYSTIC, pokedexFactory).getPokedex(), pokemonTrainer.getPokedex());
        Assert.assertEquals(pokemonTrainerFactory.createTrainer("Manon", Team.MYSTIC, pokedexFactory).getTeam(), pokemonTrainer.getTeam());
        Assert.assertEquals(pokemonTrainerFactory.createTrainer("Manon", Team.MYSTIC, pokedexFactory).getName(), pokemonTrainer.getName());

    }


}
