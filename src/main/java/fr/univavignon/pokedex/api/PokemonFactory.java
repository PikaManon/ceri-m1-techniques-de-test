package fr.univavignon.pokedex.api;


public class PokemonFactory implements IPokemonFactory{

    IPokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();


    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);
       // int rand = Math.random() * 100 ;
        //Pokemon pokemon = new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(),cp, hp, dust, candy, );
        //return pokemon;
        return null;
    }
}
