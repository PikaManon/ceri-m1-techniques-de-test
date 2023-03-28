package fr.univavignon.pokedex.api;

import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

public class IPokedexTest {

    static IPokedex pokedex;
    static Pokemon aquali;
    static Pokemon bulbizarre;

    @BeforeClass
    public static void setUpClass(){
        pokedex = Mockito.mock(IPokedex.class);
        aquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
        bulbizarre = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
    }

    @Test
    public void getSizeAtTheBeginningTest(){
        when(pokedex.size()).thenReturn(0);
        Assert.assertEquals(pokedex.size(), 0);
    }

    @Test
    public void addPokemonTest(){
        when(pokedex.addPokemon(aquali)).thenReturn(133);
        Assert.assertEquals(pokedex.addPokemon(aquali),133);
        when(pokedex.size()).thenReturn(1);
        Assert.assertEquals(pokedex.size(),1);
        when(pokedex.addPokemon(bulbizarre)).thenReturn(0);
        Assert.assertEquals(pokedex.addPokemon(bulbizarre),0);
        when(pokedex.size()).thenReturn(2);
        Assert.assertEquals(pokedex.size(),2);
    }

    @Test
    public void getPokemonWithIDTest() throws PokedexException {

        when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        Assert.assertEquals(pokedex.getPokemon(0).getIndex(),0);
        Assert.assertEquals(pokedex.getPokemon(0).getName(), "Bulbizarre");
        when(pokedex.getPokemon(1)).thenReturn(aquali);
        Assert.assertEquals(pokedex.getPokemon(1).getIndex(),133);
        Assert.assertEquals(pokedex.getPokemon(1).getName(), "Aquali");
    }

    @Test
    public void exceptionGetPokemonWithIDTest() throws PokedexException{
        when(pokedex.getPokemon(-151)).thenThrow(new PokedexException("this pokemon's index doesn't exist"));
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(-151));
    }

    @Test
    public void getPokemonsTest(){
        List<Pokemon> pokemons = new ArrayList<>(Arrays.asList(aquali, bulbizarre));
        List<Pokemon> unmodifiableList = Collections.unmodifiableList(pokemons);
        when(pokedex.getPokemons()).thenReturn(unmodifiableList);
        Assert.assertTrue(pokedex.getPokemons().contains(aquali));
        Assert.assertTrue(pokedex.getPokemons().contains(bulbizarre));
        Assert.assertThrows(UnsupportedOperationException.class,() -> {pokedex.getPokemons().remove(aquali);});
    }

    @Test
    public void getPokemonsSortedByIndexTest(){
        List<Pokemon> pokemonsSortedByIndex = new ArrayList<>(Arrays.asList(bulbizarre, aquali));
        List<Pokemon> unmodifiablePokemonsSortedByIndex = Collections.unmodifiableList(pokemonsSortedByIndex);
        when(pokedex.getPokemons(PokemonComparators.INDEX)).thenReturn(unmodifiablePokemonsSortedByIndex);
        Assert.assertEquals(pokedex.getPokemons(PokemonComparators.INDEX), unmodifiablePokemonsSortedByIndex);
    }

    @Test
    public void getPokemonsSortedByNameTest(){
        List<Pokemon> pokemonsSortedByName = new ArrayList<>(Arrays.asList(aquali, bulbizarre));
        List<Pokemon> unmodifiablePokemonsSortedByName = Collections.unmodifiableList(pokemonsSortedByName);
        when(pokedex.getPokemons(PokemonComparators.NAME)).thenReturn(unmodifiablePokemonsSortedByName);
        Assert.assertEquals(pokedex.getPokemons(PokemonComparators.NAME), unmodifiablePokemonsSortedByName);
    }

}
