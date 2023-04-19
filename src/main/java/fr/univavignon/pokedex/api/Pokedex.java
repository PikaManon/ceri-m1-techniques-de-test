package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    /**
     * The list which contains all the captured Pokemon
     */
    private List<Pokemon> capturedPokemon = new ArrayList<>();

    /**
     * the PokemonMetadataProvider to use
     */
    private IPokemonMetadataProvider pokemonMetadataProvider;
    /**
     * the PokemonFactory to use
     */
    private IPokemonFactory pokemonFactory;

    /**
     *
     * @param pokemonMetadataProvider PokemonMetadataProvider to add to this pokedex.
     * @param pokemonFactory PokemonFactory to add to this pokedex.
     */
    public Pokedex(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemonFactory = pokemonFactory;
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }


    @Override
    public int size() {
        return capturedPokemon.size();
    }
    @Override
    public int addPokemon(Pokemon pokemon) {
        capturedPokemon.add(pokemon);
        return capturedPokemon.size()-1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (Pokemon pokemon : capturedPokemon) {
            if (pokemon.getIndex() == id) {
                return pokemon;
            }
        }
        throw new PokedexException("this pokemon's index isn't in the Pokedex");

    }

    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(capturedPokemon);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        capturedPokemon.sort(order);
        List<Pokemon> unmodifiableCapturedPokemon = Collections.unmodifiableList(capturedPokemon);
        return unmodifiableCapturedPokemon;
    }


    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
