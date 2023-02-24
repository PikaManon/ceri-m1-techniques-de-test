package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    static IPokemonFactory pokemonFactory;
    static Pokemon aquali;
    static Pokemon bulbizarre;

    @BeforeClass
    public static void setUpClass(){
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        aquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
        bulbizarre = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
    }


    @Test
    public void createAqualiTest(){
        when(pokemonFactory.createPokemon(133,2729,202,5000,4)).thenReturn(aquali);
        Assert.assertEquals(pokemonFactory.createPokemon(133,2729,202,5000,4).getCp(), aquali.getCp());
        Assert.assertEquals(pokemonFactory.createPokemon(133,2729,202,5000,4).getCandy(), aquali.getCandy());
        Assert.assertEquals(pokemonFactory.createPokemon(133,2729,202,5000,4).getDust(), aquali.getDust());
        Assert.assertEquals(pokemonFactory.createPokemon(133,2729,202,5000,4).getHp(), aquali.getHp());
        Assert.assertEquals(pokemonFactory.createPokemon(133,2729,202,5000,4).getIndex(), aquali.getIndex());
        Assert.assertEquals(pokemonFactory.createPokemon(133,2729,202,5000,4).getAttack(), aquali.getAttack());
    }

    @Test
    public void createBulbizarreTest(){
        when(pokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(bulbizarre);
        Assert.assertEquals(pokemonFactory.createPokemon(0,613,64,4000,4).getCp(), bulbizarre.getCp());
        Assert.assertEquals(pokemonFactory.createPokemon(0,613,64,4000,4).getCandy(), bulbizarre.getCandy());
        Assert.assertEquals(pokemonFactory.createPokemon(0,613,64,4000,4).getDust(), bulbizarre.getDust());
        Assert.assertEquals(pokemonFactory.createPokemon(0,613,64,4000,4).getHp(), bulbizarre.getHp());
    }




}
