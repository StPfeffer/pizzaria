package br.com.pfeffer.menu.support;

import br.com.pfeffer.menu.SaborPizza;
import br.com.pfeffer.menu.enums.EnumTipoSabor;

import java.util.Arrays;
import java.util.List;

public class Sabores {
    public static List<SaborPizza> getAllSabores() {
        SaborPizza margherita = new SaborPizza("Margherita", "Molho de tomate, queijo mussarela, manjericão fresco e azeite de oliva", 25f, EnumTipoSabor.SALGADA);
        SaborPizza portuguesa = new SaborPizza("Portuguesa ", "Molho de tomate, queijo mussarela, presunto, ovos, cebola, azeitonas e pimentão", 35.0f, EnumTipoSabor.SALGADA);
        SaborPizza calabresa = new SaborPizza("Calabresa", "Molho de tomate, queijo mussarela, linguiça calabresa fatiada, cebola e azeitonas", 30.0f, EnumTipoSabor.SALGADA);
        SaborPizza pepperoni = new SaborPizza("Pepperoni ", "Molho de tomate, queijo mussarela, pepperoni (salame tipo americano) e azeitonas", 32.0f, EnumTipoSabor.SALGADA);
        SaborPizza vegetariana = new SaborPizza("Vegetariana", "Molho de tomate, queijo mussarela, tomate, cebola, pimentão, milho, cogumelos, azeitonas e brócolis", 30.0f, EnumTipoSabor.SALGADA);
        SaborPizza baiana = new SaborPizza("Baiana", "Molho de tomate, queijo mussarela, carne moída temperada com especiarias, pimenta dedo-de-moça, cebola e azeitonas", 40.0f, EnumTipoSabor.SALGADA);
        SaborPizza quatroQueijos = new SaborPizza("Quatro Queijos", "Molho de tomate, queijo mussarela, queijo gorgonzola, queijo provolone e queijo parmesão ralado", 35.0f, EnumTipoSabor.SALGADA);
        SaborPizza toscana = new SaborPizza("Toscana", "Molho de tomate, queijo mussarela, linguiça toscana, cebola, azeitonas e orégano", 35f, EnumTipoSabor.SALGADA);
        SaborPizza mexicana = new SaborPizza("Mexicana", "Molho de tomate, queijo mussarela, carne moída temperada, pimenta jalapeño, pimentão, cebola e azeitonas", 40f, EnumTipoSabor.SALGADA);
        SaborPizza frangoCatupiry = new SaborPizza("Frango com Catupiry", "Molho de tomate, queijo mussarela, frango desfiado, catupiry, milho, azeitonas e orégano", 32f, EnumTipoSabor.SALGADA);

        SaborPizza nutellaComMorango = new SaborPizza("Nutella com Morango", "Nutella, morangos fatiados e chocolate granulado", 35f, EnumTipoSabor.DOCE);
        SaborPizza bananaComCanela = new SaborPizza("Banana com Canela", "Banana fatiada, açúcar mascavo, canela em pó e chocolate branco ralado", 30f, EnumTipoSabor.DOCE);
        SaborPizza romeuEJulieta = new SaborPizza("Romeu e Julieta", "Goiabada em cubos, queijo mussarela e açúcar de confeiteiro", 35f, EnumTipoSabor.DOCE);
        SaborPizza morangoComLeiteCondensado = new SaborPizza("Morango com Leite Condensado", "Morangos fatiados, leite condensado, chocolate branco ralado e raspas de limão", 40f, EnumTipoSabor.DOCE);
        SaborPizza cocoComChocolateBranco = new SaborPizza("Coco com Chocolate Branco", "Coco ralado, chocolate branco derretido, leite de coco e raspas de limão", 32f, EnumTipoSabor.DOCE);
        SaborPizza doceDeLeiteComAmendoim = new SaborPizza("Doce de Leite com Amendoim", "Doce de leite, amendoim torrado e moído, chocolate ao leite ralado e confeitos coloridos", 36f, EnumTipoSabor.DOCE);
        SaborPizza brigadeiro = new SaborPizza("Brigadeiro", "Brigadeiro de chocolate, granulado de chocolate e raspas de chocolate", 45f, EnumTipoSabor.DOCE);
        SaborPizza beijinho = new SaborPizza("Beijinho", "Beijinho de coco, coco ralado e raspas de chocolate branco", 40f, EnumTipoSabor.DOCE);
        SaborPizza pacoca = new SaborPizza("Paçoca", "Doce de amendoim, paçoca triturada e leite condensado", 42f, EnumTipoSabor.DOCE);
        SaborPizza abacaxiComCanela = new SaborPizza("Abacaxi com Canela", "Abacaxi em cubos, canela em pó, açúcar mascavo e queijo mussarela", 35f, EnumTipoSabor.DOCE);

        SaborPizza[] sabores = {
                margherita,
                portuguesa,
                calabresa,
                pepperoni,
                vegetariana,
                baiana,
                quatroQueijos,
                toscana,
                mexicana,
                frangoCatupiry,
                nutellaComMorango,
                bananaComCanela,
                romeuEJulieta,
                morangoComLeiteCondensado,
                cocoComChocolateBranco,
                doceDeLeiteComAmendoim,
                brigadeiro,
                beijinho,
                pacoca,
                abacaxiComCanela
        };

        return Arrays.asList(sabores);
    }
}
