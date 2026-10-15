package com.nbgraciano.analisecredito.service.strategy.impl;

import com.nbgraciano.analisecredito.domain.Proposta;
import com.nbgraciano.analisecredito.service.strategy.CalculoPonto;

import java.util.Random;

public class OutrosEmprestimosEmAndamento implements CalculoPonto {


    @Override
    public int calcular(Proposta proposta) {
        return outrosEmprestimosEmAndamento() ? 0 : 80;
    }

    private boolean outrosEmprestimosEmAndamento(){
        return new Random().nextBoolean();
    }
}
