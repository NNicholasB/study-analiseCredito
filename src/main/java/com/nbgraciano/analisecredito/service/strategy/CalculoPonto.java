package com.nbgraciano.analisecredito.service.strategy;

import com.nbgraciano.analisecredito.domain.Proposta;

public interface CalculoPonto {

    int calcular(Proposta proposta);
}
