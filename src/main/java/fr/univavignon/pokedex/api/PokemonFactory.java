package fr.univavignon.pokedex.api;


import java.util.Random;

public class PokemonFactory implements IPokemonFactory{

    IPokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();


    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);
        Random rand = new Random();
        int randIV = rand.nextInt(101);
        Pokemon pokemon = new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(),cp, hp, dust, candy, randIV);
        return pokemon;
    }
}
