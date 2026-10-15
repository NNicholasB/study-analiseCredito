package com.nbgraciano.analisecredito.service.strategy.impl;

import com.nbgraciano.analisecredito.domain.Proposta;
import com.nbgraciano.analisecredito.service.strategy.CalculoPonto;

public class RendaMaiorValorSolicitado implements CalculoPonto {
    @Override
    public int calcular(Proposta proposta) {
        return  rendaMaioValorSolicitado(proposta) ? 100: 0;
    }

    private boolean rendaMaioValorSolicitado(Proposta proposta){
        return proposta.getUsuario().getRenda() > proposta.getValorSolicitado();

    }
}
