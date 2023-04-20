package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.UnmodifiableMap;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.Pokemon;

public class RocketPokemonFactory implements IPokemonFactory {

    private static Map<Integer, String> index2name;
    static {
        Map<Integer, String> aMap = new HashMap<Integer, String>();
        aMap.put(-1, "Ash's Pikachu");
        aMap.put(0, "MISSINGNO");
        aMap.put(1, "Bulbasaur");
        //TODO : Gotta map them all !
        index2name = UnmodifiableMap.unmodifiableMap(aMap);
    }

    private static int generateRandomStat() {
        int total = 0;
        for(int i=0; i < 1000000; i++)
        {
            Random rn = new Random();
            int r = rn.nextInt(2);
            total = total + r;
        }
        return total / 10000;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        String name;
        if(!index2name.containsKey(index)) {
            name = index2name.get(0);
        } else {
            name = index2name.get(index);
        }
        int attack;
        int defense;
        int stamina;
        double iv;
        if(index < 0) {
            attack = 1000;
            defense = 1000;
            stamina = 1000;
            iv = 0;
        } else {
            attack = RocketPokemonFactory.generateRandomStat();
            defense = RocketPokemonFactory.generateRandomStat();
            stamina = RocketPokemonFactory.generateRandomStat();
            iv = 1;
        }
        return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
    }

}

/**
 * les problèmes de l'implémentation de la team Rocket :
 *
 * - indice du bulbizarre ne correspond pas avec le leur, 0 dans notre version et 1 dans la leur
 * - les propriétés d'attaque, défense et stamina sont générés aléatoirement
 * - si pokemon ne fait pas partie de leur donnée, le nom du pokémon est MissingNo
 * - ils n'ont pas aquali
 * - ont un pokemon à l'index -1 alors que va de 0 à 150
 * - n utilise pas pokemon metadata
 */