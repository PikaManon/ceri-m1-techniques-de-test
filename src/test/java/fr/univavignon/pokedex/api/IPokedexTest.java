package fr.univavignon.pokedex.api;

import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.Before;
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
        //pokedex = Mockito.mock(IPokedex.class);

        aquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
        bulbizarre = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
    }

    @Before
    public void setUpTest() throws PokedexException {

        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        PokemonMetadata aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(aqualiMetadata);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        when(pokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(bulbizarre);
        pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
    }

    @Test
    public void getSizeAtTheBeginningTest(){
        //when(pokedex.size()).thenReturn(0);
        Assert.assertEquals(pokedex.size(), 0);
    }

    @Test
    public void addPokemonTest(){
        //when(pokedex.addPokemon(aquali)).thenReturn(0);
        Assert.assertEquals(pokedex.addPokemon(aquali),0);
        //when(pokedex.size()).thenReturn(1);
        Assert.assertEquals(pokedex.size(),1);
        //when(pokedex.addPokemon(bulbizarre)).thenReturn(1);
        Assert.assertEquals(pokedex.addPokemon(bulbizarre),1);
        //when(pokedex.size()).thenReturn(2);
        Assert.assertEquals(pokedex.size(),2);
    }

    @Test
    public void getPokemonWithIDTest() throws PokedexException {

        //when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        pokedex.addPokemon(aquali);
        pokedex.addPokemon(bulbizarre);
        Assert.assertEquals(pokedex.getPokemon(0).getIndex(),133);
        Assert.assertEquals(pokedex.getPokemon(0).getName(), "Aquali");
        //when(pokedex.getPokemon(133)).thenReturn(aquali);
        Assert.assertEquals(pokedex.getPokemon(1).getIndex(),0);
        Assert.assertEquals(pokedex.getPokemon(1).getName(), "Bulbizarre");
    }

    @Test
    public void exceptionGetPokemonWithIDTest() throws PokedexException{
        //when(pokedex.getPokemon(100)).thenThrow(new PokedexException("this pokemon's index isn't in the Pokedex"));
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(100));
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(-1));
    }

    @Test
    public void getPokemonsTest(){
        //List<Pokemon> pokemons = new ArrayList<>(Arrays.asList(aquali, bulbizarre));
        //List<Pokemon> unmodifiableList = Collections.unmodifiableList(pokemons);
        //when(pokedex.getPokemons()).thenReturn(unmodifiableList);
        pokedex.addPokemon(aquali);
        pokedex.addPokemon(bulbizarre);

        Assert.assertTrue(pokedex.getPokemons().contains(aquali));
        Assert.assertTrue(pokedex.getPokemons().contains(bulbizarre));
        Assert.assertThrows(UnsupportedOperationException.class,() -> {pokedex.getPokemons().remove(aquali);});
    }

    @Test
    public void getPokemonsSortedByIndexTest(){
        List<Pokemon> pokemonsSortedByIndex = new ArrayList<>(Arrays.asList(bulbizarre, aquali));
        List<Pokemon> unmodifiablePokemonsSortedByIndex = Collections.unmodifiableList(pokemonsSortedByIndex);
        //when(pokedex.getPokemons(PokemonComparators.INDEX)).thenReturn(unmodifiablePokemonsSortedByIndex);

        pokedex.addPokemon(aquali);
        pokedex.addPokemon(bulbizarre);

        Assert.assertEquals(pokedex.getPokemons(PokemonComparators.INDEX), unmodifiablePokemonsSortedByIndex);
    }

    @Test
    public void getPokemonsSortedByNameTest(){
        List<Pokemon> pokemonsSortedByName = new ArrayList<>(Arrays.asList(aquali, bulbizarre));
        List<Pokemon> unmodifiablePokemonsSortedByName = Collections.unmodifiableList(pokemonsSortedByName);
        //when(pokedex.getPokemons(PokemonComparators.NAME)).thenReturn(unmodifiablePokemonsSortedByName);
        pokedex.addPokemon(aquali);
        pokedex.addPokemon(bulbizarre);
        Assert.assertEquals(pokedex.getPokemons(PokemonComparators.NAME), unmodifiablePokemonsSortedByName);
    }

    @Test
    public void createPokemonTest() throws PokedexException {

        Pokemon testBulbizarre = pokedex.createPokemon(0,613,64, 4000,4 );
        Assert.assertEquals(testBulbizarre.getCp(), bulbizarre.getCp());
        Assert.assertEquals(testBulbizarre.getCandy(), bulbizarre.getCandy());
        Assert.assertEquals(testBulbizarre.getDust(), bulbizarre.getDust());
        Assert.assertEquals(testBulbizarre.getHp(), bulbizarre.getHp());
        Assert.assertEquals(testBulbizarre.getIndex(), bulbizarre.getIndex());
        Assert.assertEquals(testBulbizarre.getAttack(), bulbizarre.getAttack());
        Assert.assertTrue(testBulbizarre.getIv() >=0 && testBulbizarre.getIv() <=100);

    }

    @Test
    public void getPokemonMetadataTest() throws PokedexException {
        PokemonMetadata aqualiMetadata = pokedex.getPokemonMetadata(133);
        Assert.assertEquals(aqualiMetadata.getIndex(), aqualiMetadata.getIndex());
        Assert.assertEquals(aqualiMetadata.getName(), aqualiMetadata.getName());
        Assert.assertEquals(aqualiMetadata.getAttack(), aqualiMetadata.getAttack());
        Assert.assertEquals(aqualiMetadata.getDefense(), aqualiMetadata.getDefense());
        Assert.assertEquals(aqualiMetadata.getStamina(), aqualiMetadata.getStamina());
    }

}
