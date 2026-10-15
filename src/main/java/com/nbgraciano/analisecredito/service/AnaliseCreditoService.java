package com.nbgraciano.analisecredito.service;

import com.nbgraciano.analisecredito.domain.Proposta;
import com.nbgraciano.analisecredito.service.strategy.CalculoPonto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseCreditoService {

    private List<CalculoPonto> calculoPontoList;

    public AnaliseCreditoService(List<CalculoPonto> calculoPontoList) {
        this.calculoPontoList = calculoPontoList;
    }

    public void analisar(Proposta proposta){
        int pontuacao=calculoPontoList.stream().mapToInt(impl-> impl.calcular(proposta)).sum();
    }
}
